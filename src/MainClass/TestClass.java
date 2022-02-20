package MainClass;

import Node.ProgramNode;
import Parser.Parser;

import java.util.Scanner;

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


class GetInputFromUser {
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string " + s);

        int a = in.nextInt();
        System.out.println("You entered integer " + a);

        float b = in.nextFloat();
        System.out.println("You entered float " + b);

        // closing scanner
        in.close();
    }
}
