package Node;

public interface Node {

}

interface StatementNode extends Node{

}

interface Expression extends Node{
    int eval();
}

class BinaryExpression implements Expression{
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

class intLitExpression implements Expression{
    public intLitExpression(){

    }
    @Override
    public int eval() {
        return 0;
    }
}