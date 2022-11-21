package bridge;

import java.util.List;
import java.util.ArrayList;

public class User {
    private List<String> userBridge;
    private int bridgeLength;
    private List<String> answer;

    public User(List<String> answer, int bridgeLength) {
        this.userBridge = new ArrayList<>(bridgeLength);
        this.bridgeLength = bridgeLength;
        this.answer = answer;
    }
}