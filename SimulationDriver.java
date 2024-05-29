import java.util.*;

public class SimulationDriver {
    public static void main(String[] args) {
        // Initialize question manager
        QuestionManager questionManager = new QuestionManager();
        Question question = questionManager.getRandomQuestion();

        // Initialize Voting Service
        VotingService votingService = new VotingService();
        votingService.setCurrentQuestion(question);

        // Generate Students and Their Answers
        List<Student> students = generateStudents(100);  // generate 100 students
        Random random = new Random();

        // Simulate Voting
        for (Student student : students) {
            List<String> options = question.getOptions();
            String selectedOption = options.get(random.nextInt(options.size()));
            votingService.submitVote(student.getId(), selectedOption);
        }

        // Display Results
        votingService.printResults();
    }

    private static List<Student> generateStudents(int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student("ID_" + i));
        }
        return students;
    }
}