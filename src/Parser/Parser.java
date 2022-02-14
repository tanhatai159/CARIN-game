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

    public void Parse(){

    }
    public void ParseProgram(){
        ProgramNode p = new ProgramNode();
        while (AllToken.hasNext()){
            p.addStatement(ParseStatement());
        }
    }
    public StatementNode ParseStatement(){

        if(isCommand(AllToken.peek())){

        }
        else if(AllToken.peek().equals("if") || AllToken.peek().equals("else")){

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
    public void ParseBlockStatement(){

    }
    public void ParseIfStatement(){

    }
    public void ParseWhileStatement(){

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
