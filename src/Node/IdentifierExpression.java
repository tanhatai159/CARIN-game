package Node;

public class IdentifierExpression implements Expression{
    String identifier;
    public IdentifierExpression(String identifier){
        this.identifier = identifier;
    }
    @Override
    public int eval() {
        return 0;
    }
}
