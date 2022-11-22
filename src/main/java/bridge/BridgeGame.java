package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int moveCount = 1;
    private int tryCount = 1;
    private boolean tryGame = true;
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, List<String> passBridge, String moveInput) {
        passBridge = bridge.subList(0, this.moveCount);
        moveInput = this.inputView.readMoving();
        this.tryGame = this.outputView.printMap(passBridge, moveInput);
        this.moveCount++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(boolean tryGame) {
        if(!tryGame) {
            tryGame = this.inputView.readGameCommand();
            if(tryGame) {
                this.moveCount = 1;
                this.tryCount++;
            }
        }
        return tryGame;
    }

    public void playBridgeGame() {
        int size = this.inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> passBridge = new ArrayList<>();
        String moveInput = "";
        playBridgeGameMoreAndMore(bridge, passBridge, moveInput);
        endBridgeGame(passBridge, moveInput, "실패");
    }

    public void endBridgeGame(List<String> passBridge, String moveInput, String successOrFailed) {
        this.outputView.printResult(passBridge, moveInput);
        System.out.println("게임 성공 여부: " + successOrFailed);
        System.out.println("총 시도한 횟수: " + this.tryCount);
    }

    public void playBridgeGameMoreAndMore(List<String> bridge, List<String> passBridge, String moveInput) {
        while(this.tryGame) {
            move(bridge, passBridge, moveInput);
            if(bridge.size() == this.moveCount - 1) {
                endBridgeGame(passBridge, moveInput, "성공"); return;
            }
            this.tryGame = retry(this.tryGame);
        }
        endBridgeGame(passBridge, moveInput, "실패");
    }
}
