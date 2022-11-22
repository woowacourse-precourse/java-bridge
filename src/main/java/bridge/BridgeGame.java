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
        outputView.printStartMsg();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void move(String answer, String input) {
        if (!answer.equals(input)) {
            outputView.printMap(bridge, position+1, false);
            if (inputView.readGameCommand().equals("R")) {
                retry();
            } else {
                quit = true;
            }
        } else {
            outputView.printMap(bridge, ++position, true);
        }
    }

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
