package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpectedBridge {

    private List<String> expectation;

    private ExpectedBridge() {
        expectation = new ArrayList<>();
    }
    public static ExpectedBridge newInstance() {
        return new ExpectedBridge();
    }

    public void expect(String command) {
        expectation.add(command);
    }

    public List<String> getExpectation() {
        return expectation;
    }
    public int countTry() {
        return expectation.size();
    }
}
