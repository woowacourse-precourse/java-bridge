package bridge.domain;

import bridge.domain.vo.BridgeGameResult;
import bridge.domain.vo.Moving;

import java.util.List;
import java.util.Objects;

import static bridge.domain.vo.BridgeGameResult.createBridgeGameResult;
import static bridge.view.InputView.readGameCommand;
import static bridge.view.InputView.readMoving;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String QUIT_CONDITION = "Q";
    public static int RETRY_COUNT = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGameResult move(List<String> bridge, int bridgeIndex) {
        return computeGameResult(readMoving(), bridge.get(bridgeIndex));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        if (isSuccess(bridgeGameResults, bridgeSize)) {
            return false;
        }
        if (Objects.equals(readGameCommand().getGameCommand(), QUIT_CONDITION)) {
            return false;
        }
        RETRY_COUNT += 1;
        return true;
    }

    private boolean isSuccess(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        BridgeGameResult lastGameResult = bridgeGameResults.get(bridgeGameResults.size() - 1);
        if (bridgeGameResults.size() == bridgeSize && lastGameResult.getIsMatched()) {
            return true;
        }
        return false;
    }

    public boolean isContinue(BridgeGameResult bridgeGameResult, int bridgeIndex, int bridgeSize) {
        if (bridgeIndex == bridgeSize) {
            return false;
        }
        return bridgeGameResult.getIsMatched();
    }

    private BridgeGameResult computeGameResult(Moving moving, String bridgeRoom) {
        boolean isMatched = compare(moving.getMoving(), bridgeRoom);
        return createBridgeGameResult(isMatched, moving.getMoving());
    }

    private boolean compare(String moving, String bridgeRoom) {
        return Objects.equals(moving, bridgeRoom);
    }
}
