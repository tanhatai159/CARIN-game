package Node;

import Human.Cell;

import java.util.Map;

class IntLitExpression implements Expression {
    int val;

    public IntLitExpression(int val) {
        this.val = val;
    }

    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap) {
        return val;
    }
}
