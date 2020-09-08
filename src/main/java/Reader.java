import java.io.File;
import java.util.Scanner;

class Reader{

    private final File file;

    Reader(File origFile){
        this.file = origFile;
    }

    public String read() throws Exception {
        String text = "";

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            text = scanner.nextLine();
        }
        return text;
    }
}