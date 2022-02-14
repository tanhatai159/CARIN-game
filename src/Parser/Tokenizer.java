package Parser;

import java.util.LinkedList;

public class Tokenizer {
    LinkedList<String> parse;

    public Tokenizer(String s) {
        genarate(s);
        System.out.println(parse);
    }

    public String consume() {
        return parse.poll();
    }
    public boolean hasNext(){
        return parse.isEmpty();
    }
    public String Next(){
        return parse.poll();
    }

    public void Print(){
        System.out.println(parse);
    }
    public void genarate(String input) {
        parse = new LinkedList<String>();
        String line = input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
//            if(line.charAt(i) == ' ') continue;
                if(line.charAt(i) == '(' || line.charAt(i) == ')' || line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/' || line.charAt(i) == '=' || line.charAt(i) == '%'){
                    if(!sb.isEmpty()){this.parse.add(sb.toString());
                    sb = new StringBuilder();}
                    sb.append(line.charAt(i));
                    this.parse.add(sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
                if (line.charAt(i) == ' ') {
                    if(sb.isEmpty()) continue;
                    this.parse.add(sb.toString());
                    sb = new StringBuilder();
                }else{
                    sb.append(line.charAt(i));
                }

        }
        if (sb.length() > 0) this.parse.add(sb.toString());
    }

    public static void main(String[] args) {
        Tokenizer a = new Tokenizer("Flan (Laplus +Callie-LaK*JAI/DJ%Neko=KO)");
        String X = a.consume();
        a.Print();
        System.out.println(X);
    }
}
