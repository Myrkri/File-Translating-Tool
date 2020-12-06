import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

class Writer {
    String translate(String text, String origLan, String targLan){

        String result = "";
        System.setProperty("GOOGLE_API_KEY", "AIzaSyBvkISMdns7ZPDdkBZ4cZF1r6N1F0x--8E");
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        try {
            Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(origLan), Translate.TranslateOption.targetLanguage(targLan));
            result = translation.getTranslatedText();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please! Choose languages correctly");
        }
        return result;
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
