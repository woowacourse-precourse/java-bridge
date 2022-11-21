package bridge.launcher;

import static bridge.log.Log.log;

import bridge.BridgeGame;
import bridge.status.Retry;
import bridge.status.StepType;
import bridge.status.UserStatus;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BridgeGameLauncher {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private UserStatus userStatus;
    private List<String> bridges;

    public BridgeGameLauncher(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;

    }

    public void init() {
        outputView.printWelcomeMessage();
        this.userStatus = new UserStatus(new ArrayList<>());
        this.userStatus.changeNextStep(StepType.MAKE_BRIDGE);
    }

    public void run() {
        boolean isRun = true;
        while (isRun) {
            try {
                isRun = executeByStep(userStatus.getNowStep());
            } catch (NoSuchElementException e) {
                // 다리 생성 숫자를 잘못 입력 했을 경우 다시 유저에게 입력을 요청하게 작성하면
                // 테스트 케이스 통과 안됨, 요구사항과 상충. 해당 예외만 별도 처리
                break;
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    private void goToNextStep() {
        StepType nextStep = StepType.values()[userStatus.getNowStep().ordinal() + 1];
        userStatus.changeNextStep(nextStep);
    }


    private boolean executeByStep(StepType stepType) {
        if (stepType == StepType.MAKE_BRIDGE) {
            return makeBridge();
        }

        if (stepType == StepType.MOVE_BRIDGE) {
            return moveBridge(userStatus, bridges);
        }

        return retryOrQuit(userStatus);
    }


    private boolean makeBridge() {
        int bridgeSize = inputView.readBridgeSize();

        bridges = bridgeGame.makeBridge(bridgeSize);
        goToNextStep();
        return true;
    }


    private boolean moveBridge(UserStatus userStatus, List<String> bridges) {
        while (userStatus.isAvailable() && userStatus.getPosition() + 1 < bridges.size()) {
            String direction = inputView.readMoving();
            userStatus.addDirection(direction);

            bridgeGame.move(bridges, userStatus);
            outputView.printMap(userStatus);
        }

        goToNextStep();
        return true;
    }

    private boolean retryOrQuit(UserStatus userStatus) {
        if (userStatus.isAvailable()) {
            return endGame();
        }

        String command = inputView.readGameCommand();
        if (Retry.convert(command) == Retry.QUIT) {
            return endGame();
        }

        return tryAgain();
    }

    private boolean tryAgain() {
        bridgeGame.retry(userStatus);
        userStatus.changeNextStep(StepType.MOVE_BRIDGE);
        return true;
    }

    private boolean endGame() {
        outputView.printResult(userStatus);
        return false;
    }

}
