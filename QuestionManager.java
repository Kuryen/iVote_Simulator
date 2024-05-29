import java.util.*;

public class QuestionManager {
    private List<Question> questions;

    public QuestionManager() {
        this.questions = new ArrayList<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        questions.add(new Question("What is your favorite color?", Arrays.asList("Red", "Blue", "Green", "Yellow"), false));
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "Lyon", "Marseille", "Toulouse"), true));
        questions.add(new Question("Select all prime numbers", Arrays.asList("2", "3", "4", "5"), false));
        // Add more questions if needed
    }

    public Question getRandomQuestion() {
        int index = (int) (Math.random() * questions.size());
        return questions.get(index);
    }
}
