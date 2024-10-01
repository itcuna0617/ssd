import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import java.util.Arrays;

public class SSD{

    FileIO io = new FileIO();
    int[] lba = new int[100];

    public SSD(){};

    public void write(int index, String value) {
        try{
            String[] temp = io.read("nand.txt").split("\\|");
            for(int i = 0; i < lba.length; i++){
                try{
                    lba[i] = Integer.decode(temp[i]);
                } catch(NumberFormatException e){
                    lba[i] = -1;
                }
            }
        } catch(IOException e){
            System.out.println("파일이 없습니다.");
        } catch(URISyntaxException e){
            System.out.println("올바르지 않은 경로입니다.");
        }

//        lba[index] = Integer.decode(value);
        lba[index] = Integer.parseUnsignedInt(value.substring(2), 16);
        String tot = "";

        for(int i = 0; i < lba.length; i++){
            tot += "0x" + String.format("%8s" ,Integer.toHexString(lba[i])).replace(" ", "0") + (i != 99 ? "|" : "");
        }

        try{
            io.write("nand.txt", tot);
        } catch(IOException e){
            System.out.println("파일이 없습니다.");
        } catch(URISyntaxException e){
            System.out.println("올바르지 않은 경로입니다.");
        }

    }

    public String read(int index) {
        try{
            String[] temp = io.read("nand.txt").split("\\|");

            io.write("result.txt", String.format("%8s", temp[index]).replace(" ", "0"));
            return temp[index];
        } catch(IOException e){
            System.out.println("파일이 없습니다.");
//            io.write("result.txt", "0x00000000");
            return "";
        } catch(URISyntaxException e){
            System.out.println("올바르지 않은 경로입니다.");
            return "";
        }

    }
}
