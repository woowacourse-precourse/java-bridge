package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameAnswer {

    private static final String UP = "U";
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

    public List<List<String>> getMapByHistory(List<String> history) {
        List<List<String>> rvalue = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            if (isAnswer(history.get(i), i)) {
                rvalue.add(getCollectMessage(bridgeAnswer.get(i),
                        isLastIndex(history.size(), i)));
                continue;
            }
            rvalue.add(getWrongMessage(bridgeAnswer.get(i), isLastIndex(history.size(), i)));
        }
        return rvalue;
    }

    private List<String> getCollectMessage(String answer, boolean isLast) {
        if (answer.equals(UP)) {
            return BridgeShape.COLLECT_UP.getShapeMessages(isLast);
        }
        return BridgeShape.COLLECT_DOWN.getShapeMessages(isLast);
    }

    private List<String> getWrongMessage(String answer, boolean isLast) {
        if (answer.equals(UP)) {
            return BridgeShape.WRONG_UP.getShapeMessages(isLast);
        }
        return BridgeShape.WRONG_DOWN.getShapeMessages(isLast);
    }

    private boolean isLastIndex(int historySize, int index) {
        if (historySize == index + 1) {
            return true;
        }
        return false;
    }
}
