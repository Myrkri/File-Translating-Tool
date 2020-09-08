import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface extends JFrame implements ActionListener {

    private final JButton browse = new JButton("Browse...");
    private final JButton close = new JButton("Close");
    private final JButton readFile = new JButton("Translate");
    private final JTextArea original = new JTextArea(30,50);
    private final JTextArea result = new JTextArea(30,50);
    private final JButton save = new JButton("Save");

    private final JFileChooser fileChooser = new JFileChooser("C:\\");

    UserInterface(){
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        setSize(1200, 530);
        setLayout(new FlowLayout());
        setTitle("File Translate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(original);
        JScrollPane scrollPane1 = new JScrollPane(result);

        add(scrollPane);
        add(buttonPanel);

        buttonPanel.add(browse);
        buttonPanel.add(readFile);
        buttonPanel.add(save);
        buttonPanel.add(close);

        add(scrollPane1);

        browse.addActionListener(this);
        close.addActionListener(this);
        readFile.addActionListener(this);
        save.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == close){
            System.exit(0);
        }
        else if (e.getSource() == browse){
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
        else if (e.getSource() == save){
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
            String origTxt = original.getText();
            String translText = new Writer().translate(origTxt);
            result.setText(translText);
        }
    }
}
