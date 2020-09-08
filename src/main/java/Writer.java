import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.File;
import java.io.FileWriter;

class Writer {
    String translate(String text){

        System.setProperty("GOOGLE_API_KEY", "AIzaSyBvkISMdns7ZPDdkBZ4cZF1r6N1F0x--8E");
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage("en"), Translate.TranslateOption.targetLanguage("ru"));
        System.out.printf("Text: "+text+"\nTranslated text: %s\n", translation.getTranslatedText());

        return  translation.getTranslatedText();
    }
    void fileCreator(String text, File fileName) throws Exception{

        if (fileName.createNewFile()){
            System.out.println("File was created!");
        }
        else {
            System.out.println("File exists");
        }
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(text);
        fileWriter.close();
    }
}
