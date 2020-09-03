import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface extends JFrame implements ActionListener {

    private JButton browse = new JButton("Browse...");
    private JButton close = new JButton("Close");
    private JButton readFile = new JButton("Translate");
    private JTextArea original = new JTextArea(30,50);
    private JTextArea result = new JTextArea(30,50);
    private JButton save = new JButton("Save Result"); //TODO Rename it later

    private JFileChooser fileChooser = new JFileChooser("C:\\");

    private JPanel buttonPanel = new JPanel(new GridLayout(0,1));

    UserInterface(){
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
                //TODO передть метод чтения фала класса Reader и отправить туда имя и путь к файлу
            }
        }
        else if (e.getSource() == save){
            int savd = fileChooser.showSaveDialog(this);
            if (savd == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getCurrentDirectory();
            }
        }
    }
}
