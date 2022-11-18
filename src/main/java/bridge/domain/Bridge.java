package bridge.domain;

import java.util.List;

public class Bridge {

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

    public GameResult resultOf(int columnPosition) {
        bridgeFrame.subList(0, columnPosition);
        return GameResult.from(bridgeFrame.subList(0, columnPosition));
    }
}
