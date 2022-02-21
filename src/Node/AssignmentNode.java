package Node;

import Human.Cell;
import MainClass.MainGame;

import java.util.Map;

public class AssignmentNode implements StatementNode{
    Expression i;
    Expression e;
    public AssignmentNode(Expression i, Expression e){
        this.i = i;
        this.e = e;
    }
    public void eval(Cell host, Map<String,Integer> bindingMap){
        String name = ((IdentifierExpression)i).getName();
        int result = e.eval(host,bindingMap);
        if(name.equals("t")){
            MainGame.setTimeUnit(result);
        }
        else{
            bindingMap.put(name,result);
        }
    }
}
