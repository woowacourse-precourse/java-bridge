package bridge;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        if (init()) return;
        // TODO: 프로그램 구현
        while (!bridgeGame.isEnd()) {
            // Move가 실패하면 check
            try {
                if (!bridgeGame.move(inputView.readMoving()) && !bridgeGame.retry(inputView.readGameCommand())) break;
            } catch (IllegalArgumentException e) {
                System.out.println(UserResponse.ERROR.getStateInfo() + " check again");
                return;
            }
            outputView.printMap();
        }
        outputView.printResult(bridgeGame.getRetryCount(), bridgeGame.isEnd());
    }

    static boolean init() {
        inputView = new InputView();
        if (checkingUserInput()) return true;
        outputView = new OutputView(bridgeGame);
        return false;
    }

    static boolean checkingUserInput() {
        try {
            bridgeGame = new BridgeGame(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(UserResponse.ERROR.getStateInfo() + " 숫자를 입력하세요");
            return true;
        }
        return false;
    }
}
