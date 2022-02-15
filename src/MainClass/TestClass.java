package MainClass;

import Node.ProgramNode;
import Parser.Parser;

public class TestClass {
    public static void main(String[] args) {
        Parser parser = new Parser("D:\\code\\year2\\OOP\\GPS\\testCase\\forReadConfig\\ttttt");
        ProgramNode p = parser.Parse();
        System.out.println("5555");
    }
}
