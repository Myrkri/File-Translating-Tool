import java.io.File;
import java.util.Scanner;

class Reader{
    private String address = "";
    private String fileName = "";
    //private String extention = ".txt";

    Reader(String address, String fileName) {
        this.address = address;
        this.fileName = fileName;
    }
    public Reader(String address) {
        this.address = address;
    }
    void read() throws Exception {
        File file = new File(address, fileName);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String text = scanner.nextLine();
            //System.out.println(text); //test
            Writer writer = new Writer(text, fileName);
            writer.translate();
        }
    }
}