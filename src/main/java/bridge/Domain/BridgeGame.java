package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants.FrontMan;
import bridge.Database.BridgeData;
import bridge.UI.InputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static bridge.Constants.StandardTools.FAILED;
import static bridge.Constants.StandardTools.RETRY;
import static bridge.Constants.StandardTools.SUCCEED;
import static bridge.Constants.StandardTools.POSSIBLE_ZONE;
import static bridge.Constants.StandardTools.IMPOSSIBLE_ZONE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final BridgeData bridgeData = new BridgeData();
    public final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public final InputView inputView = new InputView();
    private boolean isGameSucceed;

    public BridgeGame() {
        System.out.println(FrontMan.BRIDGE_GAME_IS_BEGINNING + "\n");
    }

    public void gameStart() {
        bridgeData.setBridge(bridgeMaker.makeBridge(inputView.readBridgeLength()));
        System.out.println(bridgeData.getBridge());
        bridgeData.initializeTotalAttempt();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        List<String> bridgeDesignByUser = new ArrayList<>();
        for (int bridgeRange = 0; bridgeRange < bridgeData.getBridge().size(); bridgeRange++) {
            String nextStep = inputView.readMoving();
            bridgeDesignByUser.add(nextStep);
            bridgeData.updateBridgeDesignByUser(bridgeDesignByUser);
            if (validateNextStep(nextStep, bridgeRange) == IMPOSSIBLE_ZONE) {
                break;
            }
        }
    }

    private boolean validateNextStep(String nextStep, int indexOfBridge) {
        if (!Objects.equals(bridgeData.getBridge().get(indexOfBridge), nextStep)) {
            isGameSucceed = FAILED;
            return IMPOSSIBLE_ZONE;
        }
        validateGameSuccessfullyFinished();
        return POSSIBLE_ZONE;
    }

    public void validateGameSuccessfullyFinished() {
        if (Objects.equals(bridgeData.getBridge(), bridgeData.getBridgeDesignByUser())) {
            isGameSucceed = SUCCEED;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, "R")) {
            initializeBridgeDesignByUser();
            bridgeData.increaseAttempts();
            return RETRY;
        }
        return !RETRY;
    }

    public void initializeBridgeDesignByUser() {
        bridgeData.updateBridgeDesignByUser(Collections.emptyList());
    }

    public boolean getIsGameSucceed() {
        return this.isGameSucceed;
    }
}
