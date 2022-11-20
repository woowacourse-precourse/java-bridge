package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BridgeGameManager {

    private InputView inputView;
    private OutputView outputView;
    private List<StringBuilder> currentBridgeStatus;
    private BridgeGame bridgeGame;

    public BridgeGameManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void setUpGame() {
        outputView.printGameProgressMessage(GameProgressMessage.GAME_START_INPUT_LENGTH_MESSAGE);

        int length = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(length);
    }

    public void move() {
        while (!bridgeGame.isUserDead() && !bridgeGame.isEnd()) {
            outputView.printGameProgressMessage(GameProgressMessage.MOVE_MESSAGE);

            String direct = inputView.readMoving();
            currentBridgeStatus = bridgeGame.move(direct);
            outputView.printMap(currentBridgeStatus);
        }
    }

    public void printResult() {
        long count = bridgeGame.getGameTryCount();

        String endResult = checkEndResult();
        outputView.printResult(currentBridgeStatus, count, endResult);
    }

    public String checkEndResult() {
        final String SUCCESS_MESSAGE = "성공";
        final String FAIL_MESSAGE = "실패";

        if(bridgeGame.isEnd()) {
            return SUCCESS_MESSAGE;
        }

        return FAIL_MESSAGE;
    }

    public boolean isGameEnd() {
        if(!bridgeGame.isEnd()) {
            System.out.println(GameProgressMessage.GAME_RETRY_MESSAGE);
            String input = Console.readLine();

            return bridgeGame.retry(input);
        }
        return false;
    }

    public void exceptionalGameEnd(String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }
}
