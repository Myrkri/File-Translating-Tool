import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

class Writer {

    private String text;

    Writer(String text) {
        this.text = text;
    }

    void translate(){

        System.setProperty("GOOGLE_API_KEY", "AIzaSyBvkISMdns7ZPDdkBZ4cZF1r6N1F0x--8E");
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage("en"), Translate.TranslateOption.targetLanguage("ru"));
        System.out.printf("Translated text: "+text+"\nText: %s\n", translation.getTranslatedText());
    }
}
