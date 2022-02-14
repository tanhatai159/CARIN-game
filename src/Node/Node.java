package Node;

public interface Node {

}

interface StatementNode extends Node{

}

interface Expression extends Node{
    int eval();
}

