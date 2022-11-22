package bridge.domain;

import static bridge.constant.BridgeConstant.BRIDGE_END_LETTER;
import static bridge.constant.BridgeConstant.BRIDGE_MIDDLE_LETTER;
import static bridge.constant.BridgeConstant.BRIDGE_START_LETTER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<State> crossResult;

    public Result() {
        crossResult = new ArrayList<>();
    }

    public void addResult(State status) {
        crossResult.add(status);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(BRIDGE_START_LETTER);
        stringBuilder.append(crossResult.stream()
                        .map(State::getStatus)
                        .collect(Collectors.joining(BRIDGE_MIDDLE_LETTER)))
                .append(BRIDGE_END_LETTER);
        return stringBuilder.toString();
    }
}
