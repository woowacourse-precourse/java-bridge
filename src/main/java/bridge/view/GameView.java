package bridge.view;

import bridge.constant.Directive;
import bridge.constant.ViewStatus;
import bridge.dto.GameResult;

/**
 * InputView와 OutputView를 결합시킨 view이다.
 * 실제 유저와 상호작용하는 클래스
 */
public class GameView {

    private final InputView inputView;
    private final OutputView outputView;

    private ViewStatus status = ViewStatus.DETERMINE_BRIDGE_SIZE;

    public GameView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void makeBridge() {
        while (status == ViewStatus.DETERMINE_BRIDGE_SIZE) {
            status = inputView.makeBridge();
        }
    }

    public void move() {
        while (status == ViewStatus.DETERMINE_MOVE) {
            GameResult gameResult = inputView.move();
            status = gameResult.getNextViewStatus();
            printMapIfMoveInputValid(gameResult);
        }
    }

    private void printMapIfMoveInputValid(GameResult gameResult) {
        if (gameResult.getNextViewStatus() == ViewStatus.INVALID_MOVE_INPUT) {
            status = ViewStatus.DETERMINE_MOVE;
            return;
        }
        outputView.printMap(gameResult);
    }

    public void retry() {
        while (status == ViewStatus.DETERMINE_RETRY) {
            status = inputView.readGameCommand();
        }
    }

    public void doGame() {
        System.out.println(Directive.GAME_START.getMessage());

        while (status != ViewStatus.WIN && status != ViewStatus.LOSE) {
            makeBridge();
            move();
            retry();
        }
        printResult();
    }

    private void printResult() {
        outputView.printResult(status);
    }
}
