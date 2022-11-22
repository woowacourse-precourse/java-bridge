package bridge;

public class Application {
    BridgeGame game = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Application app = new Application();

        app.outputView.printInitMsg();
        app.init();
        while (true) {
            app.outputView.printMoveMsg();
            app.move();
            app.afterMove();
            if (app.isFail()) {
                app.outputView.printRetryMsg();
                app.retry();
            }
            if (app.isDone()) {
                app.terminate();
                return;
            }
        }

    }

    public void init() {
        try {
            game.init(inputView.readBridgeSize());
        } catch(Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            init();
        }
    }

    public void move() {
        try {
            game.move(inputView.readMoving());
        } catch(Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            move();
        }
    }

    public void afterMove() {
        String mapStatus = game.toString();
        outputView.printMap(mapStatus);
    }

    public boolean isFail() {
        return game.type.equals(BridgeGame.GameStatus.실패);
    }

    public boolean isDone() {
        return game.type.equals(BridgeGame.GameStatus.실패) || game.type.equals(BridgeGame.GameStatus.성공);
    }

    public void retry() {
        try {
            game.retry(inputView.readRetryCommand());
        } catch(Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            retry();
        }
    }

    public void terminate() {
        outputView.printResult(game.toString(), game.type.toString(), game.attempts);
    }
}
