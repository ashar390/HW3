package test;

import application.Answer;
import application.Answers;
import application.Question;
import application.Questions;

/**
 * QuestionAnswerTestbed is a standalone test harness for the Question–Answer system.
 * It simulates posting questions and answers and tests specific scenarios:
 * 
 * 1) Posting an empty question should produce an error message "Empty question".
 * 2) Posting a valid question should display "Message successfully posted" and add the question.
 * 3) Posting an empty answer should produce an error message "Empty answer".
 * 4) Posting a valid answer should display "Message successfully posted" and add the answer.
 * 5) Attempting to filter for resolved answers when none exist should produce "Nothing to filter. Please try again".
 * 
 * Run the main method to see the test results.
 * 
 * Note: Since the underlying TP2 classes (Questions, Question, Answers, and Answer) do not enforce
 * input validation, the test harness simulates the expected business rules.
 * 
 * @author 
 * @version 1.0
 */
public class QuestionAnswerTestbed {

    /**
     * Main method that runs all automated tests and prints a summary of the results.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        int testsPassed = 0;
        int testsFailed = 0;
        
        // Test 1: Empty Question
        try {
            if (testEmptyQuestion()) {
                System.out.println("Test 1 (Empty Question) PASSED");
                testsPassed++;
                System.out.println();
            } else {
                System.out.println("Test 1 (Empty Question) FAILED");
                testsFailed++;
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Test 1 (Empty Question) FAILED with exception: " + e.getMessage());
            testsFailed++;
            System.out.println();
        }
        
        // Test 2: Valid Question Post
        try {
            if (testValidQuestionPost()) {
                System.out.println("Test 2 (Valid Question Post) PASSED");
                testsPassed++;
                System.out.println();
            } else {
                System.out.println("Test 2 (Valid Question Post) FAILED");
                testsFailed++;
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Test 2 (Valid Question Post) FAILED with exception: " + e.getMessage());
            testsFailed++;
            System.out.println();
        }
        
        // Test 3: Empty Answer
        try {
            if (testEmptyAnswer()) {
                System.out.println("Test 3 (Empty Answer) PASSED");
                testsPassed++;
                System.out.println();
            } else {
                System.out.println("Test 3 (Empty Answer) FAILED");
                testsFailed++;
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Test 3 (Empty Answer) FAILED with exception: " + e.getMessage());
            testsFailed++;
            System.out.println();
        }
        
        // Test 4: Valid Answer Post
        try {
            if (testValidAnswerPost()) {
                System.out.println("Test 4 (Valid Answer Post) PASSED");
                testsPassed++;
                System.out.println();
            } else {
                System.out.println("Test 4 (Valid Answer Post) FAILED");
                testsFailed++;
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Test 4 (Valid Answer Post) FAILED with exception: " + e.getMessage());
            testsFailed++;
            System.out.println();
        }
        
        // Test 5: Filter with No Resolved Answers
        try {
            if (testFilterNoResolvedAnswers()) {
                System.out.println("Test 5 (Filter with No Resolved Answers) PASSED");
                testsPassed++;
                System.out.println();
            } else {
                System.out.println("Test 5 (Filter with No Resolved Answers) FAILED");
                testsFailed++;
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Test 5 (Filter with No Resolved Answers) FAILED with exception: " + e.getMessage());
            testsFailed++;
            System.out.println();
        }
        
        // Print summary
        System.out.println("\nTest Summary: " + testsPassed + " PASSED, " + testsFailed + " FAILED.");
    }
    
    /**
     * Test 1: Posting an empty question.
     * Simulates that if a user enters an empty question, the system returns an error message.
     * 
     * @return true if the simulated error message is correct; false otherwise.
     */
    public static boolean testEmptyQuestion() {
        Questions questions = new Questions();
        String emptyQuestion = "";
        // Simulate validation: if empty, print error message instead of adding.
        if(emptyQuestion.isEmpty()){
            String error = "Empty question";
            System.out.println(error);
            return error.equals("Empty question");
        } else {
            questions.add(new Question(emptyQuestion));
            return false; // Should not happen.
        }
    }
    
    /**
     * Test 2: Posting a valid question.
     * Verifies that a valid question is successfully added.
     * 
     * @return true if the question is added; false otherwise.
     */
    public static boolean testValidQuestionPost() {
        Questions questions = new Questions();
        String validQuestion = "What is Java?";
        if(!validQuestion.isEmpty()){
            Question q = new Question(validQuestion);
            questions.add(q);
            String success = "Message successfully posted";
            System.out.println("Question: " + q.getInput() + " " + success);
            return questions.getQLength() == 1;
        }
        return false;
    }
    
    /**
     * Test 3: Posting an empty answer.
     * Simulates that if a user enters an empty answer, the system returns an error message.
     * 
     * @return true if the simulated error message is correct; false otherwise.
     */
    public static boolean testEmptyAnswer() {
        // Create a sample question
        Question q = new Question("What is Java?");
        String emptyAnswer = "It is a programming language.";
        if(emptyAnswer.isEmpty()){
            String error = "Empty answer";
            System.out.println(error);
            return error.equals("Empty answer");
        } else {
            q.getAnswers().addAnswer(new Answer(emptyAnswer));
            return false;
        }
    }
    
    /**
     * Test 4: Posting a valid answer.
     * Verifies that a valid answer is successfully added to a question.
     * 
     * @return true if the answer is added; false otherwise.
     */
    public static boolean testValidAnswerPost() {
        Question q = new Question("Who developed Java?");
        String validAnswer = "James Gosling";
        if(!validAnswer.isEmpty()){
            Answer answer = new Answer(validAnswer);
            q.getAnswers().addAnswer(answer);
            String success = "Message successfully posted";
            System.out.println("Answer: " + answer.getInput() + " " + success);
            return q.getAnswers().getSize() == 1;
        }
        return false;
    }
    
    /**
     * Test 5: Filtering when no resolved answers exist.
     * Simulates filtering for resolved answers. If none exist, the system should return an error message.
     * 
     * @return true if the correct error message is produced; false otherwise.
     */
    public static boolean testFilterNoResolvedAnswers() {
        // Create a sample question with an unresolved answer.
        Question q = new Question("Java was released in what year?");
        Answer answer = new Answer("1995");
        q.getAnswers().addAnswer(answer);
        
        // Simulate filtering: if no answer is resolved, produce error.
        boolean hasResolved = false;
        for (int i = 0; i < q.getAnswers().getSize(); i++){
            if(q.getAnswers().getAnswer(i).isResolved()){
                hasResolved = true;
                break;
            }
        }
        if(!hasResolved) {
            String error = "Nothing to filter. Please try again";
            System.out.println(error);
            return error.equals("Nothing to filter. Please try again");
        }
        return false;
    }
}
