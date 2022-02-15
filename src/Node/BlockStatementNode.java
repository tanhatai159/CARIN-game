package Node;

import java.util.LinkedList;
import java.util.Queue;

public class BlockStatementNode implements StatementNode{
    Queue<StatementNode> q = new LinkedList<>();
    public BlockStatementNode(){

    }
    public void addStatement(StatementNode statement){
        q.add(statement);
    }
}
