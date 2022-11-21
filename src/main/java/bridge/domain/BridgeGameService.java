package bridge.domain;

import java.util.List;

public interface BridgeGameService {
    void move(String step);
    void retry(String command);
    List<List<String>> getMap();
    Boolean isGameSuccess();
}
