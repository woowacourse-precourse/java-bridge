package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameAnswer {

    private final List<String> bridgeAnswer;

    public BridgeGameAnswer(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public boolean isAnswer(String answer, int index) {
        if (bridgeAnswer.get(index).equals(answer)) {
            return true;
        }
        return false;
    }

    public List<List<String>> getResultByHistory(List<String> history) {
        List<List<String>> rvalue = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            if (isAnswer(history.get(i), i)) {
                rvalue.add(getCollectMessage(bridgeAnswer.get(i), isLastIndex(history, i)));
                continue;
            }
            rvalue.add(getWrongMessage(bridgeAnswer.get(i), isLastIndex(history, i)));
        }
        return rvalue;
    }

    private List<String> getCollectMessage(String answer, boolean isLast) {
        if (answer.equals("U")) {
            return BridgeShape.COLLECT_UP.getShapeMessages(isLast);
        }
        return BridgeShape.COLLECT_DOWN.getShapeMessages(isLast);
    }

    private List<String> getWrongMessage(String answer, boolean isLast) {
        if (answer.equals("U")) {
            return BridgeShape.WRONG_UP.getShapeMessages(isLast);
        }
        return BridgeShape.WRONG_DOWN.getShapeMessages(isLast);
    }

    private boolean isLastIndex(List<String> history, int index) {
        if (history.size() == index + 1) {
            return true;
        }
        return false;
    }
}
