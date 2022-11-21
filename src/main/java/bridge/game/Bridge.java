package bridge.game;

import static bridge.game.BridgeMoveResult.CORRECT;
import static bridge.game.BridgeMoveResult.NONE;
import static bridge.game.BridgeMoveResult.WRONG;

import bridge.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeMoveResult> bridgeUpper;
    private final List<BridgeMoveResult> bridgeLower;

    public Bridge() {
        bridgeUpper = new ArrayList<>();
        bridgeLower = new ArrayList<>();
    }

    public Bridge(List<String> initValue) {
        bridgeUpper = new ArrayList<>();
        bridgeLower = new ArrayList<>();
        for (String value : initValue) {
            parseDirectionAndUpdate(value);
        }
    }

    private void parseDirectionAndUpdate(String value) {
        Validator.validateDirectionInput(value);
        if (value.equals("U")) {
            updateUpperCorrect();
        }
        if (value.equals("D")) {
            updateLowerCorrect();
        }
    }


    public int size() {
        Validator.validateListSizeEquals(bridgeUpper.size(), bridgeLower.size());
        return bridgeUpper.size();
    }

    public String getDirectionAt(int index) {
        Validator.validateBridgeIndex(size(), index);
        return parseUpDownAt(index);
    }

    private String parseUpDownAt(int index) {
        Validator.validateBridgeElement(bridgeUpper.get(index).text(), bridgeLower.get(index).text());

        if (List.of("O", "X").contains(bridgeUpper.get(index).text())) {
            return "U";
        }

        return "D";
    }

    public void updateUpperCorrect() {
        bridgeUpper.add(CORRECT);
        bridgeLower.add(NONE);
    }

    public void updateUpperWrong() {
        bridgeUpper.add(WRONG);
        bridgeLower.add(NONE);
    }

    public void updateLowerCorrect() {
        bridgeUpper.add(NONE);
        bridgeLower.add(CORRECT);
    }

    public void updateLowerWrong() {
        bridgeUpper.add(NONE);
        bridgeLower.add(WRONG);
    }


    public List<String> getUpper() {
        return bridgeUpper.stream()
                .map(BridgeMoveResult::text)
                .collect(Collectors.toList());
    }

    public List<String> getLower() {
        return bridgeLower.stream()
                .map(BridgeMoveResult::text)
                .collect(Collectors.toList());
    }

    public void clear() {
        bridgeUpper.clear();
        bridgeLower.clear();
    }

    /**
     * update 대신 updateUpperCorrect, updateUpperWrong,<br/> updateLowerCorrect, updateLowerWrong을 사용하자
     */
    @Deprecated
    public void update(BridgeMoveResult upperResult, BridgeMoveResult lowerResult) {
        bridgeUpper.add(upperResult);
        bridgeLower.add(lowerResult);
    }
}
