package bridge.game;

import static bridge.exception.ErrorEnum.INVALID_BRIDGE_DIRECTION_STATE;
import static bridge.exception.ErrorEnum.INVALID_BRIDGE_INDEX;
import static bridge.exception.ErrorEnum.INVALID_BRIDGE_SIZE_STATE;
import static bridge.exception.ErrorEnum.INVALID_DIRECTION_INPUT;
import static bridge.game.BridgeMoveResult.CORRECT;
import static bridge.game.BridgeMoveResult.NONE;
import static bridge.game.BridgeMoveResult.WRONG;

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
        validateDirectionInput(value);
        if (value.equals("U")) {
            updateUpperCorrect();
        }
        if (value.equals("D")) {
            updateLowerCorrect();
        }
    }

    private void validateDirectionInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_DIRECTION_INPUT
                    .messageWithCause(input));
        }
    }

    public int size() {
        if (bridgeUpper.size() == bridgeLower.size()) {
            return bridgeUpper.size();
        }
        throw new IllegalStateException(INVALID_BRIDGE_SIZE_STATE
                .messageWithCause(bridgeUpper.size() + " != " + bridgeLower.size()));
    }

    public String getDirectionAt(int index) {
        try {
            return parseUpDownAt(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_INDEX.message(), e);
        }
    }

    private String parseUpDownAt(int index) {
        if (List.of("O", "X").contains(bridgeUpper.get(index).text())) {
            return "U";
        }
        if (List.of("O", "X").contains(bridgeLower.get(index).text())) {
            return "D";
        }
        throw new IllegalStateException(INVALID_BRIDGE_DIRECTION_STATE
                .messageWithCause(bridgeUpper + " " + bridgeLower));
    }

    /**
     * update 대신 updateUpperCorrect, updateUpperWrong,<br/> updateLowerCorrect, updateLowerWrong을 사용하자
     */
    @Deprecated
    public void update(BridgeMoveResult upperResult, BridgeMoveResult lowerResult) {
        bridgeUpper.add(upperResult);
        bridgeLower.add(lowerResult);
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

}
