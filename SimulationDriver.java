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
            List<String> answers = new ArrayList<>();
            if (question.isMultipleChoice()) {
                // Randomly add one or more options to simulate multiple answers
                for (int i = 0; i <= random.nextInt(question.getOptions().size()); i++) {
                    String option = question.getOptions().get(random.nextInt(question.getOptions().size()));
                    if (!answers.contains(option)) {
                        answers.add(option);
                    }
                }
            } else {
                // Select only one option
                answers.add(question.getOptions().get(random.nextInt(question.getOptions().size())));
            }
            votingService.submitVote(student.getId(), answers);
        }
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