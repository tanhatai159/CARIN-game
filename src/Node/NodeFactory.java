package Node;

public class NodeFactory {
    private static NodeFactory instance;
    private NodeFactory(){

    }
    public static NodeFactory getInstance(){
        if(instance == null){
            instance = new NodeFactory();
        }
        return instance;
    }

    public ActionNode newActionNode(String command, String direction){
        return new ActionNode(command,direction);
    }

    public AssignmentNode newAssignmentNode(Expression i, Expression e){
        return new AssignmentNode(i,e);
    }

    public BinaryExpression newBinaryExpression(Expression l, Expression r, String op){
        return new BinaryExpression(l,r,op);
    }

    public BlockStatementNode newBlockStatementNode(){
        return new BlockStatementNode();
    }

    public IdentifierExpression newIdentifierExpression(String identifier){
        return new IdentifierExpression(identifier);
    }

    public IfStatementNode newIfStatementNode(StatementNode statement1,StatementNode statement2, Expression e){
        return new IfStatementNode(statement1,statement2,e);
    }

    public IntLitExpression newIntLitExpression(int val){
        return new IntLitExpression(val);
    }

    public ProgramNode newProgramNode(){
        return new ProgramNode();
    }

    public SensorExpression newSensorExpression(String command, String direction){
        return new SensorExpression(command,direction);
    }

    public WhileStatementNode newWhileStatementNode(StatementNode statement, Expression e){
        return new WhileStatementNode(statement, e);
    }
}
