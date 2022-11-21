package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int size = InputView.readBridgeSize();
            BridgeGame game = new BridgeGame();
            game.makeBridge(size);
            bridgeGameStart(game);
        }catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void bridgeGameStart(BridgeGame game) {
        while (true) {
            while (!game.gameOver && !game.completeBridge) {
                String moving = InputView.readMoving();
                game.move(moving);
            }
            if (game.completeBridge) {
                break;
            }
            String restart = InputView.readGameCommand();
            game.retry(restart);
            if (game.retry) {
                game.gameOver = false;
            }
            if (!game.retry) {
                break;
            }
        }
    }
}
