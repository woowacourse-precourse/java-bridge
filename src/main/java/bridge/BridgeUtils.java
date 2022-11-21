package bridge;

import java.util.List;

public class BridgeUtils {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    public Bridge startBridgeGame() {
        return new Bridge(Integer.parseInt(inputView.readBridgeSize()));
    }

    public String canPass(final int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        if (bridgeNumber == 1) {
            return "U";
        }
        return null;
    }

    public void play(Bridge bridge) {
        while (!bridge.isGameOver()) {
            actWhenMoving(bridge);
        }
        actAfterLastMoving(bridge);
    }

    public void actWhenMoving(final Bridge bridge) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        outputView.printMap(bridge, bridgeGame.move(bridge, inputView.readMoving()));
    }

    public void actAfterLastMoving(final Bridge bridge) {
        if (bridge.isO(bridge.getMovings().size() - 1)) {
            printResultWhenSuccess(bridge);
        }
        if (!bridge.isO(bridge.getMovings().size() - 1)) {
            actWhenFail(bridge);
        }
    }

    public void printResultWhenSuccess(final Bridge bridge) {
        outputView.printResult(bridge, bridge.getMovings(), "성공");
    }

    public void actWhenFail(final Bridge bridge) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String gameCommand = inputView.readGameCommand();

        if (gameCommand.equals("Q")) {
            actWhenReadingQ(bridge);
        }
        if (gameCommand.equals("R")) {
            actWhenReadingR(bridge);
        }
    }

    public void actWhenReadingR(final Bridge bridge) {
        bridgeGame.retry(bridge);
        play(bridge);
    }

    public void actWhenReadingQ(final Bridge bridge) {
        outputView.printResult(bridge, bridge.getMovings(), "실패");
    }
}
