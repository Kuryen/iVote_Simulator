import java.util.*;

public class VotingService implements VoteInt {
    private QuestionInt currentQuestion;
    private Map<String, List<String>> submissions = new HashMap<>();
    private int rightCount;
    private int wrongCount;

    @Override
    public void setCurrentQuestion(QuestionInt question) {
        this.currentQuestion = question;
        submissions.clear(); // Clear previous question submissions
        rightCount = 0;
        wrongCount = 0;
    }

    @Override
    public void submitVote(String studentId, List<String> answers) {
        // Allows multiple answers for multiple-choice; single-choice questions for single answers
        if (currentQuestion.isMultipleChoice() || answers.size() == 1) {
            submissions.put(studentId, answers);
            // Check if answers are correct
            if (currentQuestion.getRightAnswers().equals(new HashSet<>(answers))) {
                rightCount++;
            } else {
                wrongCount++;
            }
        }
    }

    @Override
    public void printResults() {
        System.out.println("Results of: " + currentQuestion.getQuestionText());
        Map<String, Integer> counts = new HashMap<>();
        for (List<String> answerList : submissions.values()) {
            for (String answer : answerList) {
                counts.put(answer, counts.getOrDefault(answer, 0) + 1);
            }
        }
        counts.forEach((answer, count) -> System.out.println(answer + ": " + count));
        System.out.println(); // Blank line for readbility
        System.out.println("Correct answers: " + rightCount);
        System.out.println("Incorrect answers: " + wrongCount);
    }
}