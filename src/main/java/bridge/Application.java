package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int size = InputView.readBridgeSize();
        BridgeGame game = new BridgeGame();
        game.makeBridge(size);
        while(true){
            while (!game.gameOver && !game.completeBridge) {
                String moving = InputView.readMoving();
                game.move(moving);
            }
            System.out.println("루프탈출");
            if (game.completeBridge){
                break;
            }
            String restart = InputView.readGameCommand();
            game.retry(restart);
            if (game.retry){
                game.gameOver = false;
            }
            if (!game.retry){
                break;
            }
        }
    }
}
