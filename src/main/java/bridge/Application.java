package bridge;

import response.BridgeGameException;
import response.UserInputException;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    private static BridgeGame game = new BridgeGame();
    private static int trialCount = 0;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            startGame();
        } catch (UserInputException inputException) {
            System.out.println(inputException.getMessage());
        } catch (BridgeGameException gameException) {
            System.out.println(gameException.getMessage());
        }
    }

    private static void startGame() {
        game.trialCount++;
        outputView.printGameStartMessage();
        List<String> generatedBridge = generateBridge();
        if (!bridgeGameProcess(generatedBridge)) {
            outputView.printExitCodeRequestMessage();
            String exitCode = inputView.readGameCommand();
            if (exitCode.equals("Q")) {
                return;
            }
            game.retry();
            bridgeGameProcess(generatedBridge);
        }

        outputView.printSuccessResult(generatedBridge, game.trialCount);

    }

    private static List<String> generateBridge() {
        int bridgeSize = getBridgeSize();
        return game.initBridge(bridgeSize);
    }

    private static int getBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        return inputView.readBridgeSize();
    }

    private static boolean bridgeGameProcess(List<String> bridge) {
        boolean success = true;
        for (int i = 0; i < bridge.size(); i++) {
            outputView.printMovementRequestMessage();
            if (!game.move(bridge, i)) {
                success = false;
                break;
            }
        }

        return success;
    }
}
