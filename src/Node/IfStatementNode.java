package Node;

public class IfStatementNode implements StatementNode {
    Expression e;
    StatementNode statement1;
    StatementNode statement2;
    public IfStatementNode(StatementNode statement1,StatementNode statement2, Expression e){
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.e = e;
    }
}
