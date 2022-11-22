package bridge.domain;

import java.util.List;

public interface BridgeGameService {
    void move(String step);
    void retry();
    List<List<String>> getMaps();
    void isGameSuccess(String step);
    Boolean isValidLastStep(String step);

    int getAttemptCount();

    boolean getSuccessStatus();
}
