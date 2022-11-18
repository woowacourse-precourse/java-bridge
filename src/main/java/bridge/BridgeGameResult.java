package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 결과를 관리하는 클래스
 */
public class BridgeGameResult {

    private final List<String> upStates;
    private final List<String> downStates;

    public BridgeGameResult() {
        this.upStates = new ArrayList<>();
        this.downStates = new ArrayList<>();
    }
}
