package Node;

import MainClass.Cell;

import java.util.Map;

public class IdentifierExpression implements Expression{
    String identifier;
    public IdentifierExpression(String identifier){
        this.identifier = identifier;
    }
    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        return 0;
    }
}
