package bridge;

public class Application {

    private final BridgeGameController bridgeGameController;

    public Application() {
        this.bridgeGameController = new BridgeGameController(
                new InputView(), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator())
        );
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.init();
        application.start();
    }

    public void init() {
        this.bridgeGameController.init();
    }

    public void start() {
        while (true) {
            MoveResponseDto response = this.bridgeGameController.move();
            if (checkIsAllCorrect(response)) {
                return;
            }
            if (!(this.retry(response))) {
                return;
            }
        }
    }

    public boolean retry(MoveResponseDto response) {
        if (response.getResult().equals(Result.FAIL)) {
            return this.bridgeGameController.retry();
        }
        return Boolean.TRUE;
    }
    public boolean checkIsAllCorrect(MoveResponseDto response) {
        if (response.isAllCorrect()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
