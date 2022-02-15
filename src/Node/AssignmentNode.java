package Node;

public class AssignmentNode implements StatementNode{
    Expression i;
    Expression e;
    public AssignmentNode(Expression i, Expression e){
        this.i = i;
        this.e = e;
    }
}
