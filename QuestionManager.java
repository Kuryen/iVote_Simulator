import java.util.*;

public class QuestionManager {
    private List<Question> questions;
    private Random random = new Random();

    public QuestionManager() {
        this.questions = new ArrayList<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        questions.add(new Question("What is your favorite color?", Arrays.asList("Red", "Blue", "Green", "Yellow"), false));
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "Lyon", "Marseille", "Toulouse"), false));
        questions.add(new Question("Select all prime numbers", Arrays.asList("2", "3", "4", "5"), false));
        questions.add(new Question("Which planets are known as the 'Gas Giants'?", Arrays.asList("Jupiter", "Saturn"), true));
        // Add more questions if needed
    }

    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}
