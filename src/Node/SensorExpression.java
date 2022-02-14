package Node;

public class SensorExpression implements Expression{
    String command,direction;

    public SensorExpression(String command, String direction){
        this.command = command;
        this.direction = direction;
    }

    @Override
    public int eval() {
        return 0;
    }
}
