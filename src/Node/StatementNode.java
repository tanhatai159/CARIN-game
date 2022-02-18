package Node;

import Human.Cell;

import java.util.Map;

public interface StatementNode {
    public void eval(Cell host, Map<String,Integer> bindingMap);
}
