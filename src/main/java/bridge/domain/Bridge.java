package bridge.domain;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;

import java.util.List;

public class Bridge {

    private final int STARTING_POINT = 0;
    private final List<String> bridgeFrame;

    public Bridge(List<String> bridgeFrame) {
        this.bridgeFrame = bridgeFrame;
    }

    public static Bridge from(List<String> bridgeFrame) {
        return new Bridge(bridgeFrame);
    }

    public int size() {
        return bridgeFrame.size();
    }

    public GameResult getMatchedPathResult(int columnPosition) {
        List<String> result = bridgeFrame.subList(STARTING_POINT, columnPosition);

        if (columnPosition == bridgeFrame.size()) {
            return GameResult.of(result, ViewStatus.WIN);
        }
        return GameResult.of(result, ViewStatus.DETERMINE_MOVE);
    }

    public GameResult getUnMatchedPathResult(int columnPosition) {
        return GameResult.of(bridgeFrame.subList(STARTING_POINT, columnPosition), ViewStatus.DETERMINE_RETRY);
    }

    public boolean compare(String command, int indexOfBridge) {
        return command.equals(bridgeFrame.get(indexOfBridge));
    }
}
