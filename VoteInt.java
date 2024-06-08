import java.util.*;

public interface VoteInt {
    void setCurrentQuestion(QuestionInt question);
    void submitVote(String studentId, List<String> answers);
    void printResults();
}
