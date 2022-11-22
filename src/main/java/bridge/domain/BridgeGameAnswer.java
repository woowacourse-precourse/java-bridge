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
        List<List<String>> map = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            map.add(getMap(history, i));
        }
        return map;
    }

    private List<String> getCollectMessage(String answer, boolean isLast) {
        if (answer.equals(UP)) {
            return BridgeShape.COLLECT_UP.getShapeMessages(isLast);
        }
        return BridgeShape.COLLECT_DOWN.getShapeMessages(isLast);
    }

    private List<String> getWrongMessage(String answer, boolean isLast) {
        if (answer.equals(UP)) {
            return BridgeShape.WRONG_DOWN.getShapeMessages(isLast);
        }
        return BridgeShape.WRONG_UP.getShapeMessages(isLast);
    }

    private boolean isLastIndex(int historySize, int index) {
        if (historySize == index + 1) {
            return true;
        }
        return false;
    }

    private List<String> getMap(List<String> history, int index) {
        if (isAnswer(history.get(index), index)) {
            return getCollectMessage(bridgeAnswer.get(index), isLastIndex(history.size(), index));
        }
        return getWrongMessage(bridgeAnswer.get(index), isLastIndex(history.size(), index));
    }
}
