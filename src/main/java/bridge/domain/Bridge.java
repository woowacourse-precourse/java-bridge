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

    public void reset() {
        correct.clear();
    }
}
