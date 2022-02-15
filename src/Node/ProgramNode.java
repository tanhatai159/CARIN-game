package Node;

import java.util.LinkedList;
import java.util.Queue;

public class ProgramNode implements Program {
    Queue<StatementNode> q = new LinkedList<>();
    public void addStatement(StatementNode statement){
        q.add(statement);
    }

}
