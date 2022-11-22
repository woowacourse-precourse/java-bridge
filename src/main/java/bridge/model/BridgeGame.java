package bridge.model;

import bridge.controller.BridgeGameManager;
import bridge.controller.InputRetryOrNot;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.Application.bridgeLength;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int allTryCount = 0;
    public List<String> bridge = new ArrayList<>();
    public List<String> bridgeCheck = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int bridgeLength, BridgeGame newGame) {
        allTryCount++;

        UpperBridge upperBridge = new UpperBridge("U");
        LowerBridge lowerBridge = new LowerBridge("D");

        moveLoop(newGame, upperBridge, lowerBridge);
        getSuccess(newGame, upperBridge, lowerBridge);
    }

    public void moveLoop(BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge){
        while (newGame.bridge.size() <= bridgeLength - 1) {
            String userUpDown = InputView.readMoving();

            BridgeGameManager gameManager = new BridgeGameManager();
            boolean gameStatus = gameManager.addInputToBridge(userUpDown, newGame, upperBridge, lowerBridge);
            if (!gameStatus) {
                break;
            }
        }
    }

    public void getSuccess(BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge){
        if (newGame.bridge.equals(BridgeMaker.bridgeStructure)) {
            BridgeGameManager.finish("성공", upperBridge, lowerBridge);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry(BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge) {
        InputRetryOrNot.getRetryOrNot(newGame, upperBridge, lowerBridge);
    }

}
