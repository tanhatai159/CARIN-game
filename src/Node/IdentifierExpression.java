package Node;

import Human.Cell;
import MainClass.MainGame;
import MainClass.RandomEverything;

import java.util.Map;

public class IdentifierExpression implements Expression{
    String identifier;
    public IdentifierExpression(String identifier){
        this.identifier = identifier;
    }
    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        if(identifier.equals("t")){
            return MainGame.getTimeUnit();
        }
        if(identifier.equals("virus")){
            return host.scanVirus();
        }
        else if(identifier.equals("random")){
            return RandomEverything.useRandom().nextInt(100);
        }
        else if(bindingMap.containsKey(identifier)){
            return bindingMap.get(identifier);
        }
        else{
            bindingMap.put(identifier,0);
            return 0;
        }
    }
    public String getName(){
        return identifier;
    }
}
