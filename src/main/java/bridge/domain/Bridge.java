package bridge.domain;

import bridge.BridgeInfo;
import bridge.constant.Token;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> answer;
    private List<Boolean> correct;

    public Bridge(List<String> answer) {
        this.answer = answer;
        correct = new ArrayList<>();
    }

    public boolean update(String userInput) {
        int index = correct.size();
        correct.add(answer.get(index).equals(userInput));
        return correct.get(correct.size() - 1);
    }

    public List<BridgeInfo> getBridgeInfo(String mark) {
        List<BridgeInfo> infos = new ArrayList<>();
        for (int index = 0; index < correct.size() - 1; index++) {
            infos.add(getCorrectInfo(index, mark));
        }
        infos.add(getLastInfo(mark));
        return infos;
    }

    private BridgeInfo getCorrectInfo(int index, String mark) {
        if (answer.get(index).equals(mark)) {
            return BridgeInfo.CORRECT;
        }
        return BridgeInfo.EMPTY;
    }

    private BridgeInfo getLastInfo(String mark) {
        int index = correct.size() - 1;
        if (correct.get(index)) {
            return getCorrectInfo(index, mark);
        }
        if (answer.get(index).equals(mark)) {
            return BridgeInfo.EMPTY;
        }
        return BridgeInfo.WRONG;
    }

    public void reset() {
        correct.clear();
    }
}
