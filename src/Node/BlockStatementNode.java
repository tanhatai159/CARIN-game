package Node;

import Human.Cell;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BlockStatementNode implements StatementNode{
    Queue<StatementNode> q = new LinkedList<>();
    public BlockStatementNode(){

    }
    public void addStatement(StatementNode statement){
        q.add(statement);
    }

    @Override
    public void eval(Cell host, Map<String,Integer> bindingMap) throws Exception {
        while(!q.isEmpty()){
            q.poll().eval(host,bindingMap);
        }
    }
}
