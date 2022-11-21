package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int size = InputView.readBridgeSize();
        BridgeGame game = new BridgeGame();
        game.makeBridge(size);
        boolean gameSet = false;
        while(!gameSet){
            while (!game.gameOver) {
                String moving = InputView.readMoving();
                game.move(moving);
            }
            System.out.println("루프빠져나옴");
            String restart = InputView.readGameCommand();
            game.retry(restart);
            if (game.retry){
                game.gameOver = false;
            }
            if (!game.retry){
                gameSet = true;
            }
        }
    }
}
