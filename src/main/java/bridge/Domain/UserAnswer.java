package bridge.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserAnswer {
    private List<String> answer;

    public UserAnswer() {
        answer = new ArrayList<>();
    }

    public void addAnswer(String command) {
        answer.add(command);
    }

    public List<String> getAnswer() {
        return Collections.unmodifiableList(answer);
    }

    public int getSize() {
        return answer.size();
    }
}
