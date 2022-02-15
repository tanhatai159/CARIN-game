package Node;

import MainClass.Cell;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ProgramNode implements Program {
    Queue<StatementNode> q = new LinkedList<>();
    public ProgramNode(){

    }
    public void addStatement(StatementNode statement){
        q.add(statement);
    }
    public void eval(Cell host, Map<String,Integer> bindingMap){
        while (!q.isEmpty()){
            q.poll().eval(host,bindingMap);
        }
    }
}
