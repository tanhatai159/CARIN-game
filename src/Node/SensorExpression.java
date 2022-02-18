package Node;

import Human.Cell;

import java.util.Map;

public class SensorExpression implements Expression{
    String command,direction;

    public SensorExpression(String command, String direction){
        this.command = command;
        this.direction = direction;
    }

    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        if(command.equals("virus")){
           return host.scanVirus();
        }
        else if(command.equals("antibody")){
           return host.scanAntibody();
        }
        else if(command.equals("nearby")){
            return host.nearby(direction);
        }
        return 0;
    }
}
