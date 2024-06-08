import java.util.*;

public interface QuestionInt {
   String getQuestionText();
   List<String> getOptions();
   Set<String> getRightAnswers();
   boolean isMultipleChoice();
}