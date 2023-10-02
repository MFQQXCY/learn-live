package io.quiz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class QuizCardBuilder {

    List<QuizCard> cards = new ArrayList<>();

    public static void main(String[] args) {
        new QuizCardBuilder().go();
    }

    private void go() {
        JFrame frame = new JFrame("Quiz Card Builder");

        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        JLabel question = new JLabel("Question");
        mainPanel.add(question);

        Font font = new Font("sanserif", Font.BOLD, 24);
        JTextArea questionArea = creatJTextArea(font);
        mainPanel.add(addJScrollPane(questionArea));
        
        JLabel answer = new JLabel("Answer");
        mainPanel.add(answer);

        JTextArea anwserArea = creatJTextArea(font);
        mainPanel.add(addJScrollPane(anwserArea));
        
        JButton button = new JButton("Next Card");
        button.addActionListener(event->{
            cards.add(new QuizCard(questionArea.getText(),anwserArea.getText()));
            questionArea.setText("");
            anwserArea.setText("");
        });
        mainPanel.add(button);


        JMenuBar menuBar =new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newJMenuItem = new JMenuItem("Save");
        newJMenuItem.addActionListener(event->{
            cards.add(new QuizCard(questionArea.getText(),anwserArea.getText()));
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(frame);
            saveAll(fileChooser.getSelectedFile());

        });
        fileMenu.add(newJMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

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

    private JScrollPane addJScrollPane(JTextArea textArea){
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private JTextArea creatJTextArea(Font font){
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }
}
