package Parser;

import Node.ProgramNode;
import Node.StatementNode;

import java.beans.Statement;

public class Parser {
    Tokenizer AllToken;

    private boolean isCommand(String word){
        return word.equals("move") || word.equals("shoot");
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
        StatementNode s;

        if(isCommand(AllToken.peek())){

        }
        else if(AllToken.peek().equals("if") || AllToken.peek().equals("else")){
            s = ParseIfStatement();
        }
        else if(AllToken.peek().equals("{")){
            s = ParseBlockStatement();
        }
        else if(AllToken.peek().equals("while")){
            s = ParseWhileStatement();
        }
        return null;
    }
    public void ParseCommand(){

    }
    public void ParseAssignmentStatement(){

    }
    public void ParseActionCommand(){

    }
    public void ParseMoveCommand(){

    }
    public void ParseAttackCommand(){

    }
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
