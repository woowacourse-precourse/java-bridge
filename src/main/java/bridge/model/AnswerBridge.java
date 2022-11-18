package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerBridge {

    List<String> answerBridge;

    public AnswerBridge(final List<String> bridge) {
        this.answerBridge = bridge;
    }

    public List<Boolean> compareTo(User user) {
        List<String> userBridge = user.getChoices();
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < userBridge.size(); i++) {
            if (isSame(answerBridge.get(i), userBridge.get(i))) {
                result.add(true);
                continue;
            }
            result.add(false);
        }
        return result;
    }

    private boolean isSame(String answerBridgeWord, String userBridgeWord) {
        return answerBridgeWord.equals(userBridgeWord);
    }

}
