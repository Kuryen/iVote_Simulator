import java.util.*;

public class Question implements QuestionInt {
    private String questionText;
    private List<String> options;
    private Set<String> rightAnswers; // Stores right answers
    private boolean isMultipleChoice; // true for multiple-choice, false for single-choice

    public Question(String questionText, List<String> options, Set<String> rightAnswers, boolean isMultipleChoice) {
        this.questionText = questionText;
        this.options = options;
        this.rightAnswers = rightAnswers;
        this.isMultipleChoice = isMultipleChoice;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<String> getOptions() {
        return options;
    }

    @Override
    public Set<String> getRightAnswers() {
        return rightAnswers;
    }

    // Returns true if the question allows multiple answers, false if only one answer is allowed
    @Override
    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }
}