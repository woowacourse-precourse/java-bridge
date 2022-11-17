package bridge;

public class Controller {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run () {
        outputView.printGameStart(); // 게임 시작 출력
    }
}
