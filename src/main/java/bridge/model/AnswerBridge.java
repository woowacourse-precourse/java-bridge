package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerBridge {

    final List<String> answerBridge;

    public AnswerBridge(final List<String> bridge) {
        this.answerBridge = bridge;
    }

    public List<Boolean> compareTo(final List<String> choices) {
        List<Boolean> compareResults = new ArrayList<>();
        for (int index = 0; index < choices.size(); index++) {
            if (isSameWord(answerBridge.get(index), choices.get(index))) {
                compareResults.add(true);
                continue;
            }
            compareResults.add(false);
        }
        return compareResults;
    }

    private boolean isSameWord(final String answerBridgeWord, final String userChoiceWord) {
        return answerBridgeWord.equals(userChoiceWord);
    }

    public boolean isCorrectChoice(final int lastStep, final String lastChoice) {
        return answerBridge.get(lastStep).equals(lastChoice);
    }

    public boolean isApproachEndPoint(final List<String> userChoices) {
        int userChoicesSize = userChoices.size();
        int answerBridgeSize = answerBridge.size();
        String userLastChoice = userChoices.get(userChoices.size() - 1);
        String lastAnswer = answerBridge.get(answerBridge.size() - 1);

        if (isSameSize(userChoicesSize, answerBridgeSize) && isSameWord(userLastChoice, lastAnswer)) {
            return true;
        }
        return false;
    }

    private boolean isSameSize(final int userChoicesSize, final int answerBridgeSize) {
        return userChoicesSize == answerBridgeSize;
    }

}
