import java.util.*;

public class VotingService {
    private Question currentQuestion;
    private Map<String, String> submissions = new HashMap<>();

    public void setCurrentQuestion(Question q) {
        currentQuestion = q;
        submissions.clear(); // Clear previous question submissions
    }

    public void submitVote(String studentId, String answer) {
        if (currentQuestion != null && currentQuestion.getOptions().contains(answer)) {
            submissions.put(studentId, answer); // Overwrites any previous answer from the same student
        }
    }

    public void printResults() {
        System.out.println("Results for the question: " + currentQuestion.getQuestionText());
        Map<String, Integer> counts = new HashMap<>();
        for (String answer : submissions.values()) {
            counts.put(answer, counts.getOrDefault(answer, 0) + 1);
        }
        counts.forEach((answer, count) -> System.out.println(answer + " : " + count));
    }
}