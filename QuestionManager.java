import java.util.*;

public class QuestionManager {
    private List<QuestionInt> questions;
    private int currentIndex = 0;

    public QuestionManager() {
        questions = new ArrayList<>();
        initializeQuestions();
        Collections.shuffle(questions); // Shuffle the order of questions initially
    }

    private void initializeQuestions() {
        // Populate the list with Question objects, which implement the Questionable interface
        questions.add(new Question("What is your favorite color?", Arrays.asList("Red", "Blue", "Green", "Yellow"), false));
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "Lyon", "Marseille", "Toulouse"), false));
        questions.add(new Question("Select all prime numbers", Arrays.asList("2", "3", "4", "5"), true));
        questions.add(new Question("The Internet was originally developed as a military project in the United States.", Arrays.asList("True", "False"), true));
        questions.add(new Question("Neptune is a Gas Giant.", Arrays.asList("True", "False"), true));
        questions.add(new Question("Who wrote '1984'?", Arrays.asList("George Orwell", "Aldous Huxley", "Ray Bradbury", "Stephen King"), false));
        questions.add(new Question("What is the smallest country in the world?", Arrays.asList("Vatican City", "Monaco", "Nauru", "Liechtenstein"), false));
        questions.add(new Question("Which of these programming languages are statically typed?", Arrays.asList("Python", "Java", "C++", "JavaScript"), true));
        questions.add(new Question("What is the main function of the roots of a plant?", Arrays.asList("Photosynthesis", "Absorb nutrients", "Support leaves", "Produce flowers"), false));
        questions.add(new Question("Which year did the Titanic sink?", Arrays.asList("1912", "1905", "1898", "1923"), false));
        questions.add(new Question("The Great Wall of China was built by the Mongol Empire to protect their territory.", Arrays.asList("True", "False"), true));
        questions.add(new Question("What is the best-selling album of all time?", Arrays.asList("Thriller", "Back in Black", "The Dark Side of the Moon", "The Bodyguard"), false));
        questions.add(new Question("Water boils at 212°F at sea level.", Arrays.asList("True", "False"), true));
        // Add more questions if needed
    }

    public QuestionInt getNextQuestion() {
        if (currentIndex >= questions.size()) {
            Collections.shuffle(questions);
            currentIndex = 0;
        }
        return questions.get(currentIndex++);
    }
}
