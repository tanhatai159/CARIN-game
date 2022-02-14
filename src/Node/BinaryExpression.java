package Node;

public class BinaryExpression implements Expression{
    Expression l, r;
    String op;
    public BinaryExpression(Expression l, Expression r, String op){
        this.l = l;
        this.r = r;
        this.op = op;
    }
    @Override
    public int eval() {

        return 0;
    }
}
