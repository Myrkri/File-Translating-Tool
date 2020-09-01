import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

class Writer {

    private String text = "";

    public Writer(String text) {
        this.text = text;
    }

    void translate(){

        System.setProperty("GOOGLE_API_KEY", "AIzaSyBvkISMdns7ZPDdkBZ4cZF1r6N1F0x--8E");
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation = translate.translate(text);
        System.out.printf("Translated text: ", translation.getTranslatedText()); //TODO fix translated text
    }
}
