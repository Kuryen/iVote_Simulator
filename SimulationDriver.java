import java.util.*;

public class SimulationDriver {
    public static void main(String[] args) {
        // Initialize question manager
        QuestionManager questionManager = new QuestionManager();
        VoteInt votingService = new VotingService();

        // Generate Students and Their Answers
        List<Student> students = generateStudents(100);  // generate 100 students
        Random random = new Random();

        // Initialize Voting Service
        for (int i = 0; i < 5; i++) { // Simulate 5 different voting rounds
            QuestionInt question = questionManager.getNextQuestion();
            votingService.setCurrentQuestion(question);

            // Simulate Voting
            for (Student student : students) {  
                List<String> answers = new ArrayList<>();
                if (question.isMultipleChoice()) {
                    // Randomly add one or more options to simulate multiple answers
                    for (int j = 0; j <= random.nextInt(question.getOptions().size()); j++) {
                        String option = question.getOptions().get(random.nextInt(question.getOptions().size()));
                        if (!answers.contains(option)) {
                            answers.add(option);
                        }
                    }
                } else {
                    // For single-choice questions
                    answers.add(question.getOptions().get(random.nextInt(question.getOptions().size())));
                }
                votingService.submitVote(student.getId(), answers);
            }
            votingService.printResults();
            System.out.println(); // Blank line for readbility
        }
    }

    private static List<Student> generateStudents(int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student("ID_" + i));
        }
        return students;
    }
}