import java.util.*;

public class Question {
    private String questionText;
    private List<String> options;
    private boolean isSingleChoice;

    public Question(String questionText, List<String> options, boolean isSingleChoice) {
        this.questionText = questionText;
        this.options = options;
        this.isSingleChoice = isSingleChoice;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isSingleChoice() {
        return isSingleChoice;
    }
}