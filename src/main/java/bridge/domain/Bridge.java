package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridgeChars;

    public Bridge(List<String> bridgeChars) {
        this.bridgeChars = new ArrayList<>(bridgeChars);
    }

    public boolean isCorrect(History history) {
        return bridgeChars.equals(history.getBridgeChars());
    }

    public boolean isContinue(History history) {
        int idx = history.getBridgeChars().size() - 1;
        return history.getBridgeChars().get(idx).equals(bridgeChars.get(idx));
    }
}
