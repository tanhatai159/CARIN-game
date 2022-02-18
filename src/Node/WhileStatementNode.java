package Node;

import Human.Cell;

import java.util.Map;

public class WhileStatementNode implements StatementNode {
    Expression e;
    StatementNode statement;
    public WhileStatementNode(StatementNode statement, Expression e){
        this.statement = statement;
        this.e = e;
    }
    @Override
    public void eval(Cell host, Map<String,Integer> bindingMap){

        while (e.eval(host,bindingMap) == 0){
            statement.eval(host,bindingMap);
        }
    }
}
