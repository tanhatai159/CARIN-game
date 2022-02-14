package Node;

public class AssignmentNode implements StatementNode{
    IdentifierExpression i;
    Expression e;
    public AssignmentNode(IdentifierExpression i, Expression e){
        this.i = i;
        this.e = e;
    }
}
