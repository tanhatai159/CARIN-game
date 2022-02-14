package Node;

public class ActionNode implements StatementNode {
    String command, direction;
    public ActionNode(String command, String direction){
        this.command = command;
        this.direction = direction;
    }
}
