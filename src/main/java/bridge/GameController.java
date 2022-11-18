package bridge;

import java.util.List;

public class GameController {
    BridgeGame bridgeGame;
    int attempts = 1;
    boolean success = false;

    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (true) {
            if (startCrossBridge(bridge)) {
                break;
            }

            String commend = bridgeGame.retry();
            if (commend.equals("Q")) {
                break;
            } else if (commend.equals("R")) {
                attempts++;
            }
        }
        getGameResult();
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        return inputView.readBridgeSize();
    }

    private boolean startCrossBridge(List<String> bridge) {
        int count = 0;
        this.bridgeGame = new BridgeGame(bridge);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        while (true) {
            String moving = inputView.readMoving();
            if (!bridgeGame.move(moving, count++)) {
                outputView.printMap(bridgeGame.getResult());
                break;
            }
            outputView.printMap(bridgeGame.getResult());
        }

        if (bridge.size() == count){
            success = true;
            return true;
        }

        return false;
    }

    private void getGameResult() {
        System.out.println("최종 게임 결과");
        OutputView outputView = new OutputView();
        outputView.printMap(bridgeGame.getResult());
        if (success) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + attempts);
    }
}