package Node;

import MainClass.Cell;

import java.util.Map;

public class AssignmentNode implements StatementNode{
    Expression i;
    Expression e;
    public AssignmentNode(Expression i, Expression e){
        this.i = i;
        this.e = e;
    }
    public void eval(Cell host, Map<String,Integer> bindingMap){
        String name = ((IdentifierExpression)i).getName();
        bindingMap.put(name,e.eval(host,bindingMap));
    }
}
