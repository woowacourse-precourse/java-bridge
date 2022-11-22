package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static message.GeneralMessage.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    int flag = 1;


    public void start() { // start()는 내가 만든 메서드
        int bridgeSize = inputView.readBridgeSize();

        System.out.println(GAME_START.getMessage() + INPUT_BRIDGE_LENGTH.getMessage());
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize); // 여기까진 한 번만 실행
        // 여기부터 쭉 짜보자
        List<List<String>> currentBridge = new ArrayList<>(List.of(List.of(), List.of()));
        move(bridgeSize, answerBridge, currentBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(int index, List<String> answerBridge, List<List<String>> currentBridge) {
        String step = selectStep();
        if (step.equals("U")) {
            return goUp(index, answerBridge, currentBridge);
        }
        return goDown(index, answerBridge, currentBridge);
    }

    public List<List<String>> goUp(int index, List<String> answerBridge, List<List<String>> currentBridge) {
        currentBridge.get(1).add(" ");
        if (answerBridge.get(index).equals("U")) {
            currentBridge.get(0).add("O");
        }
        if (answerBridge.get(index).equals("D")) {
            currentBridge.get(0).add("X");
        }
        return currentBridge;
    }

    public List<List<String>> goDown(int index, List<String> answerBridge, List<List<String>> currentBridge) {
        currentBridge.get(0).add(" ");
        if (answerBridge.get(index).equals("D")) {
            currentBridge.get(1).add("O");
        }
        if (answerBridge.get(index).equals("U")) {
            currentBridge.get(1).add("X");
        }
        return currentBridge;
    }



    public String selectStep() {
        System.out.println(SELECT_UP_OR_DOWN);
        String gamerStep = inputView.readMoving();
        return gamerStep;
    }

    public String goOrStop(String gamerStep, List<String> answerBridge, int index) {
        if (answerBridge.get(index).equals(gamerStep)) {
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
        System.out.println(RETRY_OR_QUIT.getMessage());
        String retryOrQuit = inputView.readGameCommand();

    }
}
