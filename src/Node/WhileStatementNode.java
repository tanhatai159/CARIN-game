package Node;

public class WhileStatementNode implements StatementNode {
    Expression e;
    StatementNode statement;
    public WhileStatementNode(StatementNode statement, Expression e){
        this.statement = statement;
        this.e = e;
    }
}
