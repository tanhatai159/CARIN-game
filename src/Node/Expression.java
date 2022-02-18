package Node;

import Human.Cell;

import java.util.Map;

public interface Expression {
    int eval(Cell host, Map<String,Integer> bindingMap);
}
