package Parser;

import Node.ActionNode;
import Node.ProgramNode;
import Node.StatementNode;

import java.beans.Statement;

public class Parser {
    Tokenizer AllToken;

    private boolean isCommand(String word){
        return word.equals("move") || word.equals("shoot");
    }

    private boolean isDirection(String word){
        return word.equals("up") || word.equals("upright") || word.equals("right") || word.equals("downright") || word.equals("down") || word.equals("downleft") || word.equals("left") || word.equals("upleft");
    }

    public Parser(String path){
        AllToken = new Tokenizer(path);
    }

    public ProgramNode Parse(){
        ProgramNode p = ParseProgram();
        if(AllToken.hasNext()){
            return null;
        }
        return p;
    }
    public ProgramNode ParseProgram(){
        ProgramNode p = new ProgramNode();
        while (AllToken.hasNext()){
            p.addStatement(ParseStatement());
        }
        return p;
    }
    public StatementNode ParseStatement(){
        StatementNode s = null;

        if(AllToken.peek().equals("if") || AllToken.peek().equals("else")){
            s = ParseIfStatement();
        }
        else if(AllToken.peek().equals("{")){
            s = ParseBlockStatement();
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
        return null;
    }
    public StatementNode ParseAssignmentStatement(){
        StatementNode s = null;

        return null;
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
        s = new ActionNode(command,direction);
        return null;
    }
//    public void ParseMoveCommand(){
//
//    }
//    public void ParseAttackCommand(){
//
//    }
    public StatementNode ParseBlockStatement(){
        return null;
    }
    public StatementNode ParseIfStatement(){

        return null;
    }
    public StatementNode ParseWhileStatement(){
        return null;
    }
    public void ParseExpression(){

    }
    public void ParseTerm(){

    }
    public void ParseFactor(){

    }
    public void ParsePower(){

    }
    public void ParseSensorExpression(){

    }
}
