package io.quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class QuizCardBuilder {

    List<QuizCard> cards = new ArrayList<>();

    public static void main(String[] args) {
        new QuizCardBuilder().go();
    }

    private void go() {
        JFrame frame = new JFrame("Quiz Card Builder");
        JMenuBar menuBar =new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newJMenuItem = new JMenuItem("Save");
        newJMenuItem.addActionListener(event->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(frame);
            saveAll(fileChooser.getSelectedFile());

        });
        fileMenu.add(newJMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);


        Box contentBox = new Box(BoxLayout.Y_AXIS);

        JPanel panel = new JPanel();
        panel.add(contentBox);
        frame.getContentPane().add(panel);
        JLabel question = new JLabel("Question");
        contentBox.add(question);

        JTextArea questionArea = new JTextArea(10, 20);
        contentBox.add(questionArea);
        
        JLabel answer = new JLabel("Answer");
        contentBox.add(answer);

        JTextArea anwserArea = new JTextArea(10, 20);
        contentBox.add(anwserArea);
        
        JButton button = new JButton("Next Card");
        button.addActionListener(event->{
            cards.add(new QuizCard(questionArea.getText(),anwserArea.getText()));
            questionArea.setText("");
            anwserArea.setText("");
        });
        contentBox.add(button);


        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private void saveAll(File fle) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fle));
            for(QuizCard card : cards){
                writer.write(card.toString());
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}
