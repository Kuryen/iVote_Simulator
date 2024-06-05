import java.util.*;

public class Question implements QuestionInt {
    private String questionText;
    private List<String> options;
    private boolean isMultipleChoice; // true for multiple-choice, false for single-choice

    public Question(String questionText, List<String> options, boolean isMultipleChoice) {
        this.questionText = questionText;
        this.options = options;
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

    // Returns true if the question allows multiple answers, false if only one answer is allowed
    @Override
    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }
}