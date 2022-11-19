package bridge;

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
        outputView.printMessage("다리 건너기 게임을 시작합니다.\n");
        outputView.printMessage("다리의 길이를 입력해주세요.");
        int length = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(length);
    }

    public void move() {
        while (!bridgeGame.isUserDead() && !bridgeGame.isEnd()) {
            outputView.printMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");
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
        if(bridgeGame.isEnd()) {
            return "성공";
        }

        return "실패";
    }
    public boolean isGameEnd() {
        return !bridgeGame.isEnd() && bridgeGame.retry();
    }

    public void exceptionalGameEnd(String errorMessage) {
        outputView.printMessage(errorMessage);
    }
}
