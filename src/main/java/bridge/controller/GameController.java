package bridge.controller;

import bridge.code.GameStatus;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    private GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.game = new BridgeGame(this.inputView.readBridgeSize());
    }
    public static GameController start() {
        return new GameController();
    }
    public void play() {
        while (game.getGameStatus() == GameStatus.PLAY) {
            move();
        }
        //결과 출력 아웃뷰 추가
    }

    public void move() {
        boolean isMoveSuccess = game.move(inputView.readMoving());
        outputView.printMap(game.getResult());
        if (!isMoveSuccess) {
            retry();
        }
        end(game.getGameStatus());
    }

    public void retry() {
        game.retry(inputView.readGameCommand());
    }

    public void end(int gameStatus) {
        outputView.printResult(game.getResult(), successOrFailString(gameStatus == GameStatus.SUCCESS));
    }

    private String successOrFailString(boolean isSuccess){
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }

}
