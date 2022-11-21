package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static final InputView inputView;
    private static final OutputView outputView;
    private static BridgeGame bridgeGame;

    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            initializeGame();
            playUntilEnd();
            gameOver();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 게임을 초기화 한다.
     */
    private static void initializeGame() {
        outputView.printWelcome();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeNumberGenerator, bridgeSize);
    }

    /**
     * 게임이 끝날 때까지 계속 실행한다.
     */
    private static void playUntilEnd() {
        while (!bridgeGame.isEnd()) {
            boolean moved = moveToNext();
            showMap();
            checkSuccess(moved);
        }
    }

    /**
     * 사용자의 입력을 받아 다음 칸으로 이동한다.
     * @return 움직임이 성공적이면 true, 그렇지 않으면 false
     */
    private static boolean moveToNext() {
        String direction = inputView.readMoving();
        return bridgeGame.move(direction);
    }

    /**
     * 그동안 움직였던 히스토리(map)를 보여준다.
     */
    private static void showMap() {
        outputView.printMap(bridgeGame.getMap());
    }

    /**
     * 성공적으로 움직였는지 체크한다. 실패했다면 사용자에게 재시도 여부를 입력받는다.
     * @param moved 움직임의 성공 여부
     */
    private static void checkSuccess(boolean moved) {
        if (!moved) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }

    /**
     * 사용자가 게임을 종료할 때(Q 입력) 게임 결과를 보여준다.
     */
    private static void gameOver() {
        outputView.printResult(
                bridgeGame.getMap(),
                bridgeGame.isSuccess(),
                bridgeGame.getTryCount()
        );
    }
}
