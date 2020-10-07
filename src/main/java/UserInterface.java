import javax.swing.*;
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

    UserInterface(){
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        JPanel origTexPanel = new JPanel(new BorderLayout());
        JPanel resTexPanel = new JPanel(new BorderLayout());
        setSize(1200, 535);
        setLayout(new FlowLayout());
        setTitle("File Translate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(original);
        JScrollPane scrollPane1 = new JScrollPane(result);

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

        buttonPanel.add(readFile);

        add(resTexPanel);
        resTexPanel.add(new JLabel("Translated Text"), "North");
        resTexPanel.add(scrollPane1);

        item1.addActionListener(this);
        item3.addActionListener(this);
        readFile.addActionListener(this);
        item2.addActionListener(this);

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
            String origTxt = original.getText();
            String translText = new Writer().translate(origTxt);
            result.setText(translText);
        }
    }
}
