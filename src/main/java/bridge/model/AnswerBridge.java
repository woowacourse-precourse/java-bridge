package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerBridge {

    List<String> answerBridge;

    public AnswerBridge(final List<String> bridge) {
        this.answerBridge = bridge;
    }

    public List<Boolean> compareTo(final List<String> choices) {
        List<Boolean> result = new ArrayList<>();
        for (int index = 0; index < choices.size(); index++) {
            if (isSame(answerBridge.get(index), choices.get(index))) {
                result.add(true);
                continue;
            }
            result.add(false);
        }
        return result;
    }

    private boolean isSame(final String answerBridgeWord, final String userBridgeWord) {
        return answerBridgeWord.equals(userBridgeWord);
    }

    public boolean isCorrect(final User user) {
        int lastStep = user.getStep();
        String lastChoice = user.getLastChoice();
        return answerBridge.get(lastStep).equals(lastChoice);
    }

    public boolean isApproachEnd(final List<String> userChoices) {
        if (userChoices.size() == answerBridge.size()) {
            if (isSame(userChoices.get(userChoices.size()-1), answerBridge.get(answerBridge.size()-1))) {
                return true;
            }
        }
        return false;
    }

}
