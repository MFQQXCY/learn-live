package io.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class QuizCardPlayer {

    boolean isShowAnswer;
    QuizCard currentCard;
    List<QuizCard> cards;
    JTextArea textArea;
    JButton button;
    int currentCardIndex;
    JFrame frame;

    public static void main(String[] args) {
        new QuizCardPlayer().go();
    }

    private void go() {
        frame = new JFrame("Quiz Card Player");
        JPanel panel = new JPanel();
        Font font = new Font("sanserif", Font.BOLD, 24);

        textArea = new JTextArea(10, 20);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane);

        button = new JButton("Show Question");
        button.addActionListener(e -> nextCard());
        panel.add(button);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newJMenuItem = new JMenuItem("Open");
        newJMenuItem.addActionListener(event -> open());
        fileMenu.add(newJMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(500, 400);
        frame.setVisible(true);

    }

    private void nextCard() {
        if (isShowAnswer) {
            textArea.setText(currentCard.getAnswer());
            button.setText("Next Card");
            isShowAnswer = false;
        } else {
            if (currentCardIndex < cards.size()) {
                showNextCard();
            } else {
                textArea.setText("That was last card!");
                button.setEnabled(false);
            }
        }
    }

    private void showNextCard() {
        currentCardIndex++;
        currentCard = cards.get(currentCardIndex);
        textArea.setText(currentCard.getQuestion());
        button.setText("Show Answer");
        isShowAnswer = true;
    }

    private void open() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(frame);
        loadFile(fileChooser.getSelectedFile());
    }

    private void loadFile(File file) {
        try {
            cards = new ArrayList<>();
            currentCardIndex = -1;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                makeFile(line);
            }
            reader.close();
            showNextCard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeFile(String line) {
        String[] str = line.split("/");
        cards.add(new QuizCard(str[0], str[1]));
    }
}
