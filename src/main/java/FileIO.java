import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class FileIO {

    public String read(String fileName) throws IOException, URISyntaxException {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
//        System.out.println(path);
//        FileInputStream fis = new FileInputStream(path.substring(0, path.length()-7)+ "/" + fileName);
        FileInputStream fis = new FileInputStream(path + fileName);
        StringBuilder sb = new StringBuilder();

        int data;
        while((data = fis.read()) != -1) {
            sb.append((char) data);
        }

        fis.close();

        return sb.toString();
    }

    public void write(String fileName, String value) throws IOException, URISyntaxException {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
//        System.out.println(path);
//        FileOutputStream fos = new FileOutputStream(path.substring(0, path.length()-7)+ "/" + fileName);
        FileOutputStream fos = new FileOutputStream(path + fileName);

        char[] chList = value.toCharArray();
        for(int i=0; i<chList.length; i++) {
            fos.write(chList[i]);
        }

        fos.flush();
        fos.close();
    }
}
