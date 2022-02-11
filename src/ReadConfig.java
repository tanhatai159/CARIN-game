import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class ReadConfig {
    public static void readConfig(){
        Path file = Paths.get("config.txt");
        Charset charset = StandardCharsets.US_ASCII;
        try(BufferedReader reader = Files.newBufferedReader(file,charset)){
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException");
        }
    }

    public static void main(String[] args) {
        ReadConfig.readConfig();
    }
}
