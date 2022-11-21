package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants.FrontMan;
import bridge.Database.BridgeData;
import bridge.UI.InputView;
import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.StandardTools.SUCCEED;
import static bridge.Constants.StandardTools.FAILED;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final BridgeData bridgeData = new BridgeData();
    public final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public final InputView inputView = new InputView();
    private boolean isGameSucceed = SUCCEED;

    public BridgeGame() {
        System.out.println(FrontMan.BRIDGE_GAME_IS_BEGINNING + "\n");
    }

    public void gameStart() {
        bridgeData.setBridge(bridgeMaker.makeBridge(inputView.readBridgeLength()));
        bridgeData.initializeTotalAttempt();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        List<String> bridgeDesignByUser = new ArrayList<>();
        for(int bridgeRange = 0; bridgeRange < bridgeData.getBridge().size(); bridgeRange++) {
            String nextStep = inputView.readMoving();
            bridgeDesignByUser.add(nextStep);
            bridgeData.updateBridgeDesignByUser(bridgeDesignByUser);
            validateNextStep(nextStep);
        }
    }

    private void validateNextStep(String nextStep) {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean getIsGameSucceed() {
        return this.isGameSucceed;
    }
}
