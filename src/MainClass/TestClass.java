package MainClass;

import Node.ProgramNode;
import Parser.Parser;

public class TestClass {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser("D:\\code\\year2\\OOP\\GPS\\testCase\\forReadConfig\\ttttt");
//        Organ testOrgan = new Organ();
//        ReadConfig.readConfig();
//        testOrgan.generateVirus();
        ProgramNode p = parser.Parse();
        System.out.println(MainGame.getTimeUnit());
    }
}
