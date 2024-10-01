import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        SSD ssd = new SSD();

//        ssd.write(7, "0x22222222");
//        ssd.read(7);

        switch (args[0].toUpperCase()){
            case "W":
                ssd.write(Integer.parseInt(args[1]), args[2]);
                break;
            case "R":
                ssd.read(Integer.parseInt(args[1]));
                break;
            default:
                System.out.println("INVALID COMMAND");
        }
    }
}
