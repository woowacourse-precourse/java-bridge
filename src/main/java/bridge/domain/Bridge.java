package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridgeFrame;

    public Bridge(List<String> bridgeFrame) {
        this.bridgeFrame = bridgeFrame;
    }

    Bridge from(List<String> bridgeFrame) {
        return new Bridge(bridgeFrame);
    }
}
