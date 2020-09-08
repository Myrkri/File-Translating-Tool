import java.io.File;
import java.util.Scanner;

class Reader{
    public String read(File file) throws Exception {
        String text = "";

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            text = scanner.nextLine();
        }
        return text;
    }
}