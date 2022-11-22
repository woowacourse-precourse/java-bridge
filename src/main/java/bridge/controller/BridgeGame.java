/**
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */

package bridge.controller;

//Controller
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.BridgeView;
import bridge.domain.User;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    // component
    private int bridgeSize; // 총 다리 개수
    private List<String> bridgeNumber = new ArrayList<>(); // 각 다리의 정답

    //domain
    private User user = new User();

    // Util
    private final BridgeView bridgeView = new BridgeView();
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeRandomNumberGenerator);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        if(jumpNextStep()) {
            bridgeView.printMap(bridgeNumber, user.getCurrentBridge(), false);
            return true;
        }

        bridgeView.printMap(bridgeNumber, user.getCurrentBridge(), true);
        return false;
    }

    /**
     * 사용자가 다음 칸으로 이동할 수 있을지 확인하는 기능
     */
    private boolean jumpNextStep() {
        user.moveNextBridge();

        if(user.getNextStep().equals(bridgeNumber.get(user.getCurrentBridge() - 1))) {
            return false;
        }

        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.setNextStep(null);
        user.goBackToFirstBridge();
    }

    /**
     * 사용자가 게임을 시작할 때, 게임 시작 문구 출력을 위한 메서드
     */
    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 사용자가 다리 개수를 입력할 때 사용하는 메서드
     */
    public int enterNumberOfBridge() {
        this.bridgeSize = bridgeView.readBridgeSize();
        this.bridgeNumber = bridgeMaker.makeBridge(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 다음 칸을 선택하는 기능
     */
    public void enterNextStep() {
        this.user.setNextStep(bridgeView.readNextStep());
    }

    /**
     * 사용자의 게임 진행 여부를 입력받는 기능
     */
    public boolean enterRetry() {
        String command = bridgeView.readRetry();

        if(command.equals("R")) {
            return true;
        }

        return false;
    }

}
