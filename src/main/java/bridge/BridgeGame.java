package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    String userMovingValue = inputView.readMoving();
    OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    // 외부에 새 currentBridge를 선언하고, 하나씩 추가하는 방식은 어떨까ㅏㅏ..
    public void move(List<String> bridgeMap, List<String> currentBridge, String userMoving) {
        if (bridgeMap.get(currentBridge.size()).equals(userMoving)) {
            currentBridge.add("O");
            return ;
        }
        currentBridge.add(" ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userCommand) {
        if (userCommand.equals("R")) {
            return true;
        }
        if (userCommand.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하였습니다."); // 여기 어차피 도달 못할텐디..
    }

    public void gamePlay() {
        List<String> upperCurrentBridge = new ArrayList<>();
        List<String> lowerCurrentBridge = new ArrayList<>();
        List<String> answer = bridgeMaker.makeBridge(inputView.readBridgeSize());
        for (int i = 0; i < inputView.readBridgeSize(); i++) {
            move(answer, upperCurrentBridge, inputView.readMoving());
            outputView.printMap(upperCurrentBridge);
            move(answer, lowerCurrentBridge, inputView.readMoving());
            outputView.printMap(lowerCurrentBridge);
        }
    }
}
