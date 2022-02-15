package Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Tokenizer {
    LinkedList<String> parse;

    public Tokenizer(String s) {
        Path file = Paths.get(s);
        StringBuilder sb = new StringBuilder();
        String line;
        Charset charset = StandardCharsets.US_ASCII;
        try(BufferedReader reader = Files.newBufferedReader(file,charset)){
            line = reader.readLine();
            while(line != null){
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            generate(sb.toString());
        } catch (IOException e) {
        }
    }

    public String consume() {
        return parse.poll();
    }

    public void consume(String s) throws Exception {
        if(s.equals(parse.peek())) consume();
        else throw new Exception();

    }

    public boolean hasNext(){
        return parse.isEmpty();
    }
    public String peek(){
        return parse.peek();
    }
    public boolean peek(String word){
        if(peek() == null){
            return false;
        }
        return peek().equals(word);
    }

    public void print(){
        System.out.println(parse);
    }
    public void generate(String input) {
        parse = new LinkedList<>();
        String line = input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
//            if(line.charAt(i) == ' ') continue;
            if(line.charAt(i) == '\n'){
                if(!sb.isEmpty()){this.parse.add(sb.toString());
                    sb = new StringBuilder();}
                continue;
            }
                if(line.charAt(i) == '(' || line.charAt(i) == ')' || line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/' || line.charAt(i) == '=' || line.charAt(i) == '%' || line.charAt(i) == '{' || line.charAt(i) == '}' || line.charAt(i) == '^'){
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
        Tokenizer a = new Tokenizer("Genetic_Code\\Genetic_Code.txt");
    }
}
