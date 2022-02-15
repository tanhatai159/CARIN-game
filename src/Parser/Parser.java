package Parser;

import Node.*;
import MainClass.Cell;

import java.util.ArrayList;

public class Parser {
    Tokenizer AllToken;
    NodeFactory nf = NodeFactory.getInstance();

    private boolean isCommand(String word){
        return word.equals("move") || word.equals("shoot");
    }

    private boolean isDirection(String word){
        return word.equals("up") || word.equals("upright") || word.equals("right") || word.equals("downright") || word.equals("down") || word.equals("downleft") || word.equals("left") || word.equals("upleft");
    }

    private boolean isNumericWithDecimal(String word){
        try {
            double d = Double.parseDouble(word);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isNumeric(String word){
        try{
            int i = Integer.parseInt(word);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isReservedWord(String word){
        return word.equals("down") || word.equals("downleft") || word.equals("downright") ||
                word.equals("else") || word.equals("if") || word.equals("left") || word.equals("move") ||
                word.equals("nearby") || word.equals("right") || word.equals("shoot") || word.equals("then") ||
                word.equals("up") || word.equals("upleft") || word.equals("upright") || word.equals("virus") ||
                word.equals("while");
    }

    public Parser(String path){
        AllToken = new Tokenizer(path);
    }

    public ProgramNode Parse(){
        ProgramNode p = nf.newProgramNode();
        if(AllToken.hasNext()){
            return null;
        }
        return p;
    }
    public ProgramNode ParseProgram(){
        ProgramNode p = nf.newProgramNode();
        while (AllToken.hasNext()){
            p.addStatement(ParseStatement());
        }
        return p;
    }
    public StatementNode ParseStatement(){
        StatementNode s = null;

        if(AllToken.peek().equals("if")){
            s = ParseIfStatement();
        }
        else if(AllToken.peek().equals("{") || AllToken.peek().equals("}")){
            if(AllToken.peek().equals("{")){
                AllToken.consume();
                s = ParseBlockStatement();
            }
        }
        else if(AllToken.peek().equals("while")){
            s = ParseWhileStatement();
        }
        else{
            s = ParseCommand();
        }
        return s;
    }
    public StatementNode ParseCommand(){
        StatementNode s = null;
        if(isCommand(AllToken.peek())){
            s = ParseActionCommand();
        }
        else{
            s = ParseAssignmentStatement();
        }
        return s;
    }
    public StatementNode ParseAssignmentStatement(){
        StatementNode s = null;
        Expression e = null;
        Expression identifier = null;
        try {
            if(!isNumericWithDecimal(AllToken.peek())){  //to check if this is not number.
                identifier = ParseExpression();
            }
            else{
                throw new Exception();
            }
            AllToken.consume("=");
            e = ParseExpression();
        }catch (Exception ex){
            System.err.println("Can't use this genetic code.");
        }
        s = new AssignmentNode(identifier, e);
        return s;
    }
    public StatementNode ParseActionCommand(){
        StatementNode s = null;
        String command = AllToken.consume();
        String direction = null;
        try {
            if(isDirection(AllToken.peek())){
                direction = AllToken.consume();
            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            System.err.println("Can't use this genetic code.");
        }
        s = nf.newActionNode(command,direction);
        return s;
    }
//    public void ParseMoveCommand(){
//
//    }
//    public void ParseAttackCommand(){
//
//    }
    public StatementNode ParseBlockStatement(){
        BlockStatementNode s = nf.newBlockStatementNode();
        try {
            while (AllToken.hasNext()){
                s.addStatement(ParseStatement());
                AllToken.consume("}");
            }
        }catch (Exception ex){
            System.err.println("Don't have '}'");
        }
        return s;
    }
    public StatementNode ParseIfStatement(){
        AllToken.consume();
        StatementNode s1 = null, s2 = null;
        Expression e = null;
        try{
            AllToken.consume("(");
            e = ParseExpression();
            AllToken.consume(")");
        }catch (Exception ex){
            System.err.println("Don't have '(' or ')'");
        }
        try{
            AllToken.consume("then");
            s1 = ParseStatement();
        }catch (Exception ex){
            System.err.println("Don't have 'then'");
        }
        try {
            AllToken.consume("else");
            s2 = ParseStatement();
        }catch (Exception ex){
            System.err.println("Don't have 'else'");
        }
        IfStatementNode i = nf.newIfStatementNode(s1,s2,e);
        return i;
    }
    public StatementNode ParseWhileStatement(){
        AllToken.consume();
        StatementNode s = null;
        Expression e = null;
        WhileStatementNode w = null;
        try {
            AllToken.consume("(");
            e = ParseExpression();
            AllToken.consume(")");
        }catch (Exception ex){
            System.err.println("Don't have '(' or ')'");
        }
            s = ParseStatement();
            w = nf.newWhileStatementNode(s,e);
        return w;
    }
    public Expression ParseExpression(){
        Expression e = ParseTerm();
        while(AllToken.peek("+") || AllToken.peek("-")){
            String operator = AllToken.consume();
            Expression snd = ParseTerm();
            e = nf.newBinaryExpression(e,snd,operator);
        }
        return e;
    }
    public Expression ParseTerm(){
        Expression e = ParseFactor();
        while(AllToken.peek("*") || AllToken.peek("/") || AllToken.peek("%")){
            String operator = AllToken.consume();
            Expression snd = ParseFactor();
            e = nf.newBinaryExpression(e,snd,operator);
        }
        return e;
    }
    public Expression ParseFactor(){
        Expression e = ParsePower();
        while(AllToken.peek("^")){
            String operator = AllToken.consume();
            Expression snd = ParsePower();
            e = nf.newBinaryExpression(e,snd,operator);
        }
        return e;
    }
    public Expression ParsePower(){
        Expression e = null;
        if(AllToken.peek("virus") || AllToken.peek("antibody") || AllToken.peek("nearby")){
            e = ParseSensorExpression();
        }
        else if(isNumeric(AllToken.peek())){
            int number = Integer.parseInt(AllToken.consume());
            try {
                if(number >= 0){
                    e = nf.newIntLitExpression(number);
                }
                else{
                    throw new Exception();
                }
            }catch (Exception ex){
                System.err.println("Can't use negative number");
            }
        }
        else if(AllToken.peek("(")){
            AllToken.consume();
            e = ParseExpression();
            try{
                AllToken.consume(")");
            }catch (Exception ex){
                System.err.println("Don't have ')' ");
            }
        }
        else{
            try {
                if(!isReservedWord(AllToken.peek())){
                    e = nf.newIdentifierExpression(AllToken.consume());
                }
                else{
                    throw new Exception();
                }
            }catch (Exception ex){
                System.err.println("Can't use reserved word");
            }
        }
        return e;
    }
    public Expression ParseSensorExpression(){
        String command = AllToken.consume(), direction = null;
        SensorExpression e = null;
        try{
            if(isDirection(AllToken.peek())){
                direction = AllToken.consume();
            }
            else{
                throw new Exception();
            }
        }catch (Exception ex){
            System.err.println("this word isn't direction");
        }
        e = nf.newSensorExpression(command,direction);
        return e;
    }
}
