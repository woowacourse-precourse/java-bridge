package bridge;

import bridge.provider.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame game;

    public void beginGame() {
        init();
        do {
            running();
            ending();
        } while (game.isStillMoving());
        outputView.printResult(game);
    }

    private void init() {
        outputView.printStartingGame();
        outputView.printBridgeLength();
        makeBridge();
        System.out.println("--------");
    }

    private void ending() {
        if (game.isGameWinning()) {
            return;
        }
        outputView.printRetryOrQuit();
        retryOrQuit();
    }

    private void makeBridge() {
        while (true) {
            try {
                game = new BridgeGame(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }

    private void running() {
        do {
            moving();
        } while (game.isStillMoving());
    }

    private void moving() {
        outputView.printMoving();
        move();
        outputView.printMap(outputView.makeMap());
    }

    private void move(){
        while (true){
            try {
                game.move(inputView.readMoving());
                return;
            }catch (IllegalArgumentException e){
                System.out.print("[ERROR]");
            }
        }
    }

    private void retryOrQuit() {
        while (true) {
            try {
                game.retry(inputView.readGameCommand());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }
}
