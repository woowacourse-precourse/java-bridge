package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameSet = true;
        while(gameSet == true){
            int size = InputView.readBridgeSize();
            BridgeGame game = new BridgeGame();
            game.makeBridge(size);
            while (!game.gameOver) {
                String moving = InputView.readMoving();
                game.move(moving);
            }
            String restart = InputView.readGameCommand();
            game.retry(restart);
            if (!game.retry){
                gameSet = false;
            }
        }
    }
}
