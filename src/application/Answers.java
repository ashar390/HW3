package application;
import java.util.ArrayList;

/**
 * This class is responsible for the CRUD operations of a list of answers.
 */

public class Answers {
    private ArrayList<Answer> answers = new ArrayList<Answer>();
    private Question question;
    
    public Answers(Question question) {
        this.question = question;
    }
    
    // Add answer to the list (update, create)
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
    
    // Read answer in the list (read)
    public Answer getAnswer(int i) {
        return answers.get(i);
    }
    
    // Fetch the corresponding question (read)
    public Question getQuestion() {
        return question;
    }
    
    // Remove a given answer from the list (delete)
    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }
    
    // Check if there are answers
    public boolean isEmpty() {
        return answers.size() == 0;
    }
    
    // Return how many answers there are
    public int getSize() {
        return answers.size();
    }
}
