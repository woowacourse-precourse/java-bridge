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
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    int bridgeSize;
    int gameCount = 1;
    boolean canGo;

    public void game() {
        List<String> answerBridge = start();
        List<List<String>> currentBridge = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
        repeatGame(answerBridge, currentBridge);
    }

    private void repeatGame(List<String> answerBridge, List<List<String>> currentBridge) {
        canGo = true;
        int index = 0;
        currentBridge.get(0).clear();
        currentBridge.get(1).clear();
        while ((canGo == true) && (index < bridgeSize)) {
            outputView.printMap(move(index, answerBridge, currentBridge));
            index++;
        }
        if (canGo == true) {
            outputView.printResult(currentBridge, true, gameCount);
            return;
        }
        if (canGo == false) {
            String restartOrQuit = retry();
            if (restartOrQuit.equals("Q")) {
                outputView.printResult(currentBridge, false, gameCount);
                return;
            }
            gameCount++;
            repeatGame(answerBridge, currentBridge);
        }

    }

    public List<String> start() {
        System.out.println(GAME_START.getMessage() + INPUT_BRIDGE_LENGTH.getMessage());
        bridgeSize = inputView.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        return answerBridge;
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
            return currentBridge;
        }
        currentBridge.get(0).add("X");
        canGo = false;
        return currentBridge;
    }

    public List<List<String>> goDown(int index, List<String> answerBridge, List<List<String>> currentBridge) {
        currentBridge.get(0).add(" ");
        if (answerBridge.get(index).equals("D")) {
            currentBridge.get(1).add("O");
            return currentBridge;
        }
        currentBridge.get(1).add("X");
        canGo = false;
        return currentBridge;
    }

    public String selectStep() {
        System.out.println(SELECT_UP_OR_DOWN.getMessage());
        String gamerStep = inputView.readMoving();
        return gamerStep;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        System.out.println(RETRY_OR_QUIT.getMessage());
        String retryOrQuit = inputView.readGameCommand();
        return retryOrQuit;
    }
}
