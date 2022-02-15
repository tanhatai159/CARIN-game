package Node;

import MainClass.Cell;
import MainClass.MainGame;

import java.util.Map;

public class IdentifierExpression implements Expression{
    String identifier;
    public IdentifierExpression(String identifier){
        this.identifier = identifier;
    }
    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        if(bindingMap.containsKey(identifier)){
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
