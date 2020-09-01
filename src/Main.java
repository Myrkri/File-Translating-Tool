public class Main {

    public static void main(String[] args) throws Exception{

        String address = "C:\\Users\\Valentyn\\IdeaProjects\\file_translate\\Texts";
        String fileName = "test.txt";

       // Reader reader = new Reader("C:\\test.txt");
        Reader reader = new Reader(address, fileName);

        reader.read();
    }
}
