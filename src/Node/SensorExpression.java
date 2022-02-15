package Node;

import MainClass.Cell;

import java.util.Map;

public class SensorExpression implements Expression{
    String command,direction;

    public SensorExpression(String command, String direction){
        this.command = command;
        this.direction = direction;
    }

    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        return 0;
    }
}
