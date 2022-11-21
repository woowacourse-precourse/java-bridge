package bridge;

import java.util.Arrays;
import java.util.List;

import static view.GeneralMessage.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public void start() { // start()에 모든 과정들을 다 담아야하는 것으로 의도한 것 같다.
        int bridgeSize = inputView.readBridgeSize();

        System.out.println(GAME_START + INPUT_BRIDGE_LENGTH);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize); // 여기까진 한 번만 실행


    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int bridgeSize) {
        System.out.println(SELECT_UP_OR_DOWN);
        String upDown = inputView.readMoving(); // 경계선


    }

    public String goOrStop(String upDown, List<String> answerBridge, int index) {
        if (answerBridge.get(index).equals(upDown)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        System.out.println(RETRY_OR_QUIT);
        String retryOrQuit = inputView.readGameCommand();
        if (retryOrQuit.equals("R")) {
            // 처음으로 다시 돌아가기
        } else if (retryOrQuit.equals("Q")) {
            // 끝내고 결과 보기
        }
    }
}
