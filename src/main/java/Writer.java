import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.File;
import java.io.FileWriter;

class Writer {

    private String text;
    private String fileName;

    Writer(String text, String fileName) {
        this.text = text;
        this.fileName = fileName;
    }

    void translate(){

        System.setProperty("GOOGLE_API_KEY", "AIzaSyBvkISMdns7ZPDdkBZ4cZF1r6N1F0x--8E");
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage("en"), Translate.TranslateOption.targetLanguage("ru"));
        System.out.printf("Translated text: "+text+"\nText: %s\n", translation.getTranslatedText());
        try {
            fileCreator();
            FileWriter fileWriter = new FileWriter("E:\\" + fileName);
            fileWriter.write(translation.getTranslatedText());
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void fileCreator() throws Exception{
        File file = new File("E:\\" + fileName);
        if (file.createNewFile()){
            System.out.println("File was created!");
        }
        else {
            System.out.println("File exists");
        }
    }
}
