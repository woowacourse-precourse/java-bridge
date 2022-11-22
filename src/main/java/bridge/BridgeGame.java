package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView = new InputView();
    private  OutputView outputView = new OutputView();
    private List<String> bridge;
    private int position = 0;
    private int tryCount = 1;
    private boolean quit = false;

    private void startBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(String answer, String input) {
        if (!answer.equals(input)) {
            outputView.printMap(bridge, position+1, false);
            if (inputView.readGameCommand().equals("R")) {
                retry();
            } else {
                quit = true;
            }
        } else {
            position++;
            outputView.printMap(bridge, position, true);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        position = 0;
        tryCount++;
    }

    private void endBridgeGame(){
        outputView.printEndMsg();
        outputView.printMap(bridge, position, !quit);
        if (quit == true) {
            outputView.printResult("실패", tryCount);
        } else {
            outputView.printResult("성공", tryCount);
        }
    }

    public void run() {
        startBridgeGame();
        while (position <= bridge.size()-1 && quit == false) {
            move(bridge.get(position), inputView.readMoving());
        }
        endBridgeGame();
    }
}
