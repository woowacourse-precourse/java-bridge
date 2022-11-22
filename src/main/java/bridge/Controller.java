package bridge;

public class Controller {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startController() {
        outputView.printStart();
    }

    public void setBridgeController() {
        try {
            final String input = inputView.readBridgeSize();
            bridgeGame.setBridge(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBridgeController();
        }
    }

    public void moveController() {
        try {
            final String move = inputView.readMoving();
            outputView.printMap(bridgeGame.move(move));
            subMoveController(bridgeGame.getUserState());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveController();
        }
    }

    private void subMoveController(String userState) {
        if (userState.equals("실패")) {
            retry();
        } else if (userState.equals("진행중")) {
            moveController();
        } else if (userState.equals("성공")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), userState);
        }
    }

    private void retry() {
        try {
            final String command = new Command(inputView.readGameCommand()).getCommand();
            subRetry(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry();
        }
    }

    private void subRetry(String command) {
        if (command.equals("R")) {
            bridgeGame.retry();
            moveController();
        } else if (command.equals("Q")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), bridgeGame.getUserState());
        }
    }
}
