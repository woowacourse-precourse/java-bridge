package bridge;

import java.util.List;

import static bridge.WordType.*;

public class BridgeGameUi {

    private final InputView inputView;
    private final InputValidation inputValidation;
    private final OutputView outputView;
    private BridgeGameRun bridgeGameRun;
    private boolean result;

    public BridgeGameUi(InputView inputView, InputValidation inputValidation, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        int size = getBridgeSizeByValidation();

        bridgeGameRun = new BridgeGameRun();
        bridgeGameRun.bridgeGameGenerate(size);

        bridgeGameStart();
        bridgeGameEnd();
    }

    private int getBridgeSizeByValidation() {
        while (true) {
            try {
                String bridgeSize = inputView.readBridgeSize();
                return inputValidation.readBridgeSizeValidation(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void bridgeGameStart() {
        do {
            String direct = getReadMovingByValidation();

            result = bridgeGameRun.gameRun(direct);
            List<List<String>> bridgeMap = bridgeGameRun.bridgeMapGenerate();

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

    private boolean isGameEnd() {
        if (!result && !isRetry()) {
            return true;
        }
        return bridgeGameRun.isEndBridge();
    }

    private boolean isRetry() {
        String command = getGameCommandByValidation();

        if (command.equals(RESTART.getWord())) {
            bridgeGameRun.retry();
            return true;
        }
        return false;
    }

    private String getGameCommandByValidation() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                inputValidation.readGameCommandValidation(command);
                return command;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void bridgeGameEnd() {
        outputView.printResultTitle();
        List<List<String>> bridgeMap = bridgeGameRun.bridgeMapGenerate();
        outputView.printMap(bridgeMap);

        int retryCount = bridgeGameRun.getRetryCount();
        String message = getResultMessage();
        outputView.printResult(message, retryCount);
    }

    private String getResultMessage() {
        if (result) {
            return SUCCESS.getWord();
        }
        return FAIL.getWord();
    }
}