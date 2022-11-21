package bridge;

public class Application {

    public static void main(String[] args) {
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
            if (game.completeBridge) {break;}
            if (afterGameOver(game)) {break;}
        }
    }

    private static boolean afterGameOver(BridgeGame game) {
        String restart = InputView.readGameCommand();
        game.retry(restart);
        if (game.retry) {
            game.gameOver = false;
        }
        if (!game.retry) {return true;}
        return false;
    }
}
