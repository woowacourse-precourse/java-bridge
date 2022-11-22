package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    int bridgeSize = inputView.readBridgeSize();
    List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int trial) {
        List<String> userMoveHistory = new ArrayList<String>();
        for (int i = 0; i < bridgeSize; i++) {
            String userMove = inputView.readMoving();
            userMoveHistory.add(userMove);
            outputView.printMap(userMoveHistory, bridge, bridgeSize);
            if (!bridge.get(i).equals(userMove)) {
                retry(inputView.readGameCommand(), trial, userMoveHistory);
                return;
            }
        }
        System.out.println("최종 게임 결과");
        outputView.printMap(userMoveHistory, bridge, bridgeSize);
        outputView.printResult("성공", trial);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand, int trial, List<String> userMoveHistory) {
        if (gameCommand.equals("R")) {
            move(trial + 1);
        }
        if (gameCommand.equals("Q")) {
            System.out.println("최종 게임 결과");
            outputView.printMap(userMoveHistory, bridge, bridgeSize);
            outputView.printResult("실패", trial);
        }

    }
}
