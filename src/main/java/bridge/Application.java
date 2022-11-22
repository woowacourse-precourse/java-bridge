package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(); //한 번 만든 걸로 계속 쓰는 게 나으니까 main에 ..?
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(inputView, outputView);
        gameController.startGame();
    }
}
