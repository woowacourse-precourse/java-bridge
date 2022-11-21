package bridge;

import java.util.List;

public class BridgeGameRun {

    private final InputView inputView;
    private final InputValidation inputValidation;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private boolean result;

    public BridgeGameRun(InputView inputView, InputValidation inputValidation, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        int size = getBridgeSizeByValidation();

        bridgeGameGenerate(size);
        bridgeGameStart();
        bridgeGameEnd();
    }

    private int getBridgeSizeByValidation() {
        while (true) {
            try {
                int size = getNumberToBridgeSize(inputView.readBridgeSize());
                inputValidation.readBridgeSizeValidation(size);
                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void bridgeGameGenerate(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    private void bridgeGameStart() {
        do {
            String direct = getReadMovingByValidation();
            gameRun(direct);

            List<List<String>> bridgeMap = bridgeGame.getBridgeMap();
            outputView.printMap(bridgeMap);

        } while (!isGameEnd());
    }

    private String getReadMovingByValidation() {
        while (true) {
            try {
                String direct = inputView.readMoving();
                inputValidation.readMovingValidation(direct);
                return direct;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void gameRun(String direct) {
        result = bridgeGame.move(direct);
        bridgeGame.bridgeMark(direct, result);
    }

    private boolean isGameEnd() {
        if (!result && !isRetry()) {
            return true;
        }
        if (bridgeGame.isEndBridge()) {
            return true;
        }
        return false;
    }

    private boolean isRetry() {
        String command = inputView.readGameCommand();
        inputValidation.readGameCommandValidation(command);

        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private void bridgeGameEnd() {
        outputView.printResultTitle();
        List<List<String>> bridgeMap = bridgeGame.getBridgeMap();
        outputView.printMap(bridgeMap);

        int retryCount = bridgeGame.getRetryCount();
        String message = getResultMessage();
        outputView.printResult(message, retryCount);
    }

    private String getResultMessage() {
        if (result) {
            return "성공";
        }
        return "실패";
    }

    private int getNumberToBridgeSize(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
//ToDo: 에러 검증부분 묶어서 리팩토링