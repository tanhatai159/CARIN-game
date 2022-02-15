package Node;

import MainClass.Cell;

import java.util.Map;

public class ActionNode implements StatementNode {
    String command, direction;
    public ActionNode(String command, String direction){
        this.command = command;
        this.direction = direction;
    }
    public void eval(Cell host, Map<String,Integer> bindingMap){

    }
}
