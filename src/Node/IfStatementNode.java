package Node;

import Human.Cell;

import java.util.Map;

public class IfStatementNode implements StatementNode {
    Expression e;
    StatementNode statement1;
    StatementNode statement2;
    public IfStatementNode(StatementNode statement1,StatementNode statement2, Expression e){
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.e = e;
    }
    @Override
    public void eval(Cell host, Map<String,Integer> bindingMap) throws Exception {
        if(e.eval(host,bindingMap) > 0){
            statement1.eval(host,bindingMap);
        }
        else{
            statement2.eval(host,bindingMap);
        }
    }
}
