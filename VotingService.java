import java.util.*;

public class VotingService implements VoteInt {
    private QuestionInt currentQuestion;
    private Map<String, List<String>> submissions = new HashMap<>();

    @Override
    public void setCurrentQuestion(QuestionInt question) {
        this.currentQuestion = question;
        submissions.clear(); // Clear previous question submissions
    }

    @Override
    public void submitVote(String studentId, List<String> answers) {
        if (currentQuestion.isMultipleChoice()) {
            // Allow multiple answers for multiple-choice questions
            submissions.put(studentId, new ArrayList<>(answers));
        } else {
            // For single-choice questions, ensure only one answer is submitted
            if (answers.size() == 1) {
                submissions.put(studentId, answers);
            } else {
                System.out.println("Error: Only one answer is allowed for single-choice quesitons.");
            }
        }
    }

    @Override
    public void printResults() {
        System.out.println("Results of the question: " + currentQuestion.getQuestionText());
        Map<String, Integer> counts = new HashMap<>();
        for (List<String> answerList : submissions.values()) {
            for (String answer : answerList) {
                counts.put(answer, counts.getOrDefault(answer, 0) + 1);
            }
        }
        counts.forEach((answer, count) -> System.out.println(answer + ": " + count));
    }
}