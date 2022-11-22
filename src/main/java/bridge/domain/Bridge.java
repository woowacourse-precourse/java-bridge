package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> answer;
    private List<Boolean> correct;

    Bridge(List<String> answer) {
        this.answer = answer;
        correct = new ArrayList<>();
    }

    public boolean update(String userInput) {
        int index = correct.size();
        correct.add(answer.get(index).equals(userInput));
        return correct.get(correct.size()-1);
    }

    public void reset() {
        correct.clear();
    }
}
