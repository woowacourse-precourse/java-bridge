package bridge;

import bridge.enums.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {

    InputView inputView;
    OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 다리 길이를 입력받고 다리를 생성후 해당 다리를 정답으로 한 게임 준비
     * @params bridgeGame 진행하고 있는 게임 객체
     * */
    public BridgeGame prepareBridgeGame() throws IllegalArgumentException {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answerBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return new BridgeGame(answerBridge);
    }

    /**
     * 게임 시작
     * @params bridgeGame 진행하고 있는 게임 객체
     * */
    public void startBridgeGame(BridgeGame bridgeGame) throws IllegalArgumentException {
        boolean isGaming = true;
        while (isGaming) {
            BridgeGameResultDto moveResult = moveStep(bridgeGame);
            if (moveResult.getGameStatus().equals(GameStatus.SUCCESS)) {
                isGaming = gameSuccess(moveResult);
            }
            if (moveResult.getGameStatus().equals(GameStatus.FAIL)) {
                isGaming = gameFail(bridgeGame,moveResult);
            }
        }
    }

    /**
     * 칸 하나를 이동하는 기능
     * @params bridgeGame 진행하고 있는 게임 객체
     * @return BridgeGameResultDto step 이동 후 반환되는 평가값
     * */
    private BridgeGameResultDto moveStep(BridgeGame bridgeGame) throws IllegalArgumentException {
        BridgeGameResultDto moveResult = bridgeGame.move(inputView.readMoving());
        outputView.printMap(moveResult.getGradingBoard());
        return moveResult;
    }

    /**
     * 게임 성공 시 수행하는 기능
     * @params moveResult 한 칸 선택하고 받은 점수판
     * @return 게임 진행 여부. 게임을 끝낸다면 false, 게임을 이어서 한다면 true
     * */
    private boolean gameSuccess(BridgeGameResultDto moveResult) {
        outputView.printResult(moveResult);
        return false;
    }

    /**
     * 게임 실패 후 종료/재시작 선택
     * @params bridgeGame 진행하고 있는 게임 객체
     * @params moveResult 한 칸 선택하고 받은 점수판
     * @return 게임 진행 여부. 게임을 끝낸다면 false, 게임을 이어서 한다면 true
     * */
    private boolean gameFail(BridgeGame bridgeGame, BridgeGameResultDto moveResult) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            outputView.printResult(moveResult);
            return false;
        }
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
        }
        return true;
    }

}

