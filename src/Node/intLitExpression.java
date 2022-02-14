package Node;

class intLitExpression implements Expression {
    int val;

    public intLitExpression(int val) {
        this.val = val;
    }

    @Override
    public int eval() {
        return val;
    }
}
