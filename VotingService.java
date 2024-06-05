import java.util.*;

public class VotingService {
    private Question currentQuestion;
    private Map<String, List<String>> submissions = new HashMap<>();

    public void setCurrentQuestion(Question q) {
        currentQuestion = q;
        submissions.clear(); // Clear previous question submissions
    }

    public void submitVote(String studentId, List<String> answers) {
        if (currentQuestion.isMultipleChoice()) {
            // Allow multiple answers for multiple-choice questions
            submissions.put(studentId, new ArrayList<>(answers));
        } else {
            // For single-choice questions, ensure only one answer is submitted
            if (answers.size() == 1) {
                submissions.put(studentId, answers);
            } else {
                System.out.println("Error: This is a single-choice question. Only one answer is allowed.");
            }
        }
    }

    public void printResults() {
        System.out.println("Results for the question: " + currentQuestion.getQuestionText());
        Map<String, Integer> counts = new HashMap<>();
        for (List<String> answerList : submissions.values()) {
            for (String answer : answerList) {
                counts.put(answer, counts.getOrDefault(answer, 0) + 1);
            }
        }
        counts.forEach((answer, count) -> System.out.println(answer + " : " + count));
    }
}