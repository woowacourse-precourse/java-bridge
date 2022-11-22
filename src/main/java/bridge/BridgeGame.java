package bridge;

import bridge.enums.BridgeDisplay;
import bridge.enums.BridgeGameCommand;
import bridge.models.BridgeBluePrint;
import bridge.models.BridgeResult;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private BridgeBluePrint bluePrint;
    private BridgeMaker maker;
    private List<String> bridge;
    private BridgeResult result;

    public BridgeGame(BridgeBluePrint bluePrint, BridgeMaker maker) {
        this.bluePrint = bluePrint;
        this.maker = maker;
        bridge = makeBridge();
        result = makeBridgeResult();
    }

    public List<String> makeBridge() {
        return maker.makeBridge(bluePrint.getSize());
    }

    public BridgeResult makeBridgeResult() {
        return new BridgeResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        int index = result.getResultSize();
        boolean correct = moving.equals(bridge.get(index));
        result.add(moving, correct);
        if (bridge.size() == result.getResultSize()) {
            return true;
        }
        return !correct;
    }

    public List<String>[] getMap() {
        return result.getResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.init();
    }

    public boolean isSuccess() {
        return result.isSuccess();
    }

    public int getRetryCount() {
        return result.getCount();
    }
}
