package Node;

class IntLitExpression implements Expression {
    int val;

    public IntLitExpression(int val) {
        this.val = val;
    }

    @Override
    public int eval() {
        return val;
    }
}
