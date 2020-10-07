import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface extends JFrame implements ActionListener {

    private final JButton readFile = new JButton("Translate");
    private final JTextArea original = new JTextArea(30,50);
    private final JTextArea result = new JTextArea(30,50);

    private final JFileChooser fileChooser = new JFileChooser("C:\\");
    private final JMenuItem item1 = new JMenuItem("Open");
    private final JMenuItem item2 = new JMenuItem("Save");
    private final JMenuItem item3 = new JMenuItem("Close");

    String[] origLangs = {"English", "Russian", "Turkish", "French", "German", "Greek", "Estonian", "Bulgarian", "Italian"};
    String[] tranLangs = {"Russian", "English", "Turkish", "French", "German", "Greek", "Estonian", "Bulgarian", "Italian"};
    private final JComboBox orig = new JComboBox(origLangs);
    private final JComboBox trns = new JComboBox(tranLangs);

    UserInterface(){
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        JPanel origTexPanel = new JPanel(new BorderLayout());
        JPanel resTexPanel = new JPanel(new BorderLayout());
        setSize(1200, 570);
        setLayout(new FlowLayout());
        setTitle("File Translate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(original);
        JScrollPane scrollPane1 = new JScrollPane(result);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File(.txt)", "txt");

        fileChooser.setDialogTitle("Select text file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);

        JMenu menu = new JMenu("Menu");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);

        add(origTexPanel);
        origTexPanel.add(new JLabel("Original Text"),"North");
        origTexPanel.add(scrollPane);
        add(buttonPanel);

        buttonPanel.add(orig);
        buttonPanel.add(readFile);
        buttonPanel.add(trns);

        add(resTexPanel);
        resTexPanel.add(new JLabel("Translated Text"), "North");
        resTexPanel.add(scrollPane1);

        item1.addActionListener(this);
        item3.addActionListener(this);
        readFile.addActionListener(this);
        item2.addActionListener(this);
        orig.addActionListener(this);
        trns.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == item3){
            System.exit(0);
        }
        else if (e.getSource() == item1){
            int appr = fileChooser.showOpenDialog(this);
            if (appr == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                    String text = new Reader().read(file);
                    original.setText(text);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        else if (e.getSource() == item2){
            int savd = fileChooser.showSaveDialog(this);
            if (savd == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String text = result.getText();
                try {
                    new Writer().fileCreator(text, file);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
        else if (e.getSource() == readFile){
            String[] origLangs = {"en", "ru", "tr", "fr", "de", "el", "et", "bg", "it"};
            String[] tranLangs = {"ru", "en", "tr", "fr", "de", "el", "et", "bg", "it"};
            int abbOrLan = orig.getSelectedIndex();
            int abbTargLan = trns.getSelectedIndex();
            String abbLanOr = origLangs[abbOrLan];
            String abbLanTarg = tranLangs[abbTargLan];
            String origTxt = original.getText();
            String translText = new Writer().translate(origTxt, abbLanOr, abbLanTarg);
            result.setText(translText);
        }
    }
}
