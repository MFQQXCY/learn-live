package io.quiz;

public class QuizCard {
    
    String question;
    String answer;

    

    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public char[] getWriteString() {
        return null;
    }
    @Override
    public String toString() {
        return question+"/"+answer+"\n";
    }

    


    
}
