package Node;

import MainClass.Cell;

import java.util.Map;

public class BinaryExpression implements Expression{
    Expression l, r;
    String op;
    public BinaryExpression(Expression l, Expression r, String op){
        this.l = l;
        this.r = r;
        this.op = op;
    }
    @Override
    public int eval(Cell host, Map<String,Integer> bindingMap){
        int left = l.eval(host,bindingMap), right = r.eval(host,bindingMap);
        return switch (op) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            case "^" -> left ^ right;
            default -> 0;
        };
    }
}
