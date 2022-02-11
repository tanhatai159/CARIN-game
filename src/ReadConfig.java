import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class ReadConfig {
    public static void readConfig() throws Exception {
        int m,n, credits, buyCost, virusHP, antibodyHP, virusAtk, virusGain, antibodyAtk, antibodyGain, moveCost;
        double rate;
        Path file = Paths.get("config.txt");
        Charset charset = StandardCharsets.US_ASCII;
        try(BufferedReader reader = Files.newBufferedReader(file,charset)){
            String line = null;
            //first line
            line = reader.readLine();
            String arr[] = line.split(" ");
            m = Integer.parseInt(arr[0]);
            n = Integer.parseInt(arr[1]);
            //second line
            line = reader.readLine();
            rate = Double.parseDouble(line);
            //third line
            line = reader.readLine();
            arr = line.split(" ");
            credits = Integer.parseInt(arr[0]);
            buyCost = Integer.parseInt(arr[1]);
            //fourth line
            line = reader.readLine();
            arr = line.split(" ");
            virusHP = Integer.parseInt(arr[0]);
            antibodyHP = Integer.parseInt(arr[1]);
            //fifth line
            line = reader.readLine();
            arr = line.split(" ");
            virusAtk = Integer.parseInt(arr[0]);
            virusGain = Integer.parseInt(arr[1]);
            //sixth line
            line = reader.readLine();
            arr = line.split(" ");
            antibodyAtk = Integer.parseInt(arr[0]);
            antibodyGain = Integer.parseInt(arr[1]);
            //seventh line
            line = reader.readLine();
            moveCost = Integer.parseInt(line);
        } catch (IOException e) {
            System.err.format("IOException");
        } catch (Exception e){
            throw new Exception("not correct input");
        }

    }

    public static void main(String[] args) throws Exception {
        ReadConfig.readConfig();
    }
}
