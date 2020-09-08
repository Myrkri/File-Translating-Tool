import java.io.File;
import java.util.Scanner;

class Reader{
    private  String address;
    private String fileName = "";
    private File file;

    Reader(String address, String fileName) {
        this.address = address;
        this.fileName = fileName;
    }
    Reader(File origFile){
        this.file = origFile;
    }
    /*public Reader(String address) {
        this.address = address;
    }*/
    public String read() throws Exception {
        //File file = new File(address, fileName);
        String text = "";

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            text = scanner.nextLine();
            /*Writer writer = new Writer(text, fileName);
            writer.translate();*/
        }
        return text;
    }
}