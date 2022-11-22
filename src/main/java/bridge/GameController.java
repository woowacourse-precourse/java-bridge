package bridge;

import bridge.model.BridgeGame;
import bridge.model.domains.constants.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.constants.OutputMessage;
import bridge.view.template.MovingMap;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 사용자 입출력 및 게임 결과의 상호작용을 흐름에 따라 실행하고 관리하는 클래스
 */
public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private MovingMap movingMap;
    private BridgeGame bridgeGame;

    /**
     * 다리 게임을 실행한다.
     */
    public void run() {
        try {
            outputView.printMessage(OutputMessage.START_GAME);
            initializeBridgeGame(new BridgeRandomNumberGenerator());
            playRoundsUntilFailOrDone();
            showResult();
        } catch (Exception exception) {
            outputView.printGameErrorMessage(exception.getMessage());
        }
    }

    /**
     * 정해진 다리 번호 생성기를 이용해 다리 게임의 기본 값을 설정한다.
     */
    private void initializeBridgeGame(BridgeNumberGenerator generator) {
        outputView.printMessage(OutputMessage.ASK_BRIDGE_SIZE);
        int bridgeSize = askUntilGetLegalAnswer(inputView::readBridgeSize,
                BridgeSize.MINIMUM.getValue(), BridgeSize.MAXIMUM.getValue());
        bridgeGame = new BridgeGame(bridgeSize, new BridgeMaker(generator));
        movingMap = new MovingMap();
    }

    /**
     * 사용자가 다리 건너기를 실패하거나, 모두 완료할 때까지 게임 라운드를 반복한다.
     */
    private void playRoundsUntilFailOrDone() {
        playOneRound();
        if (bridgeGame.hasPlayerFailed()) {
            retryOrQuit();
            return;
        }
        if (!bridgeGame.hasAllMovingDone()) {
            playRoundsUntilFailOrDone();
        }
    }

    /**
     * 하나의 게임 라운드를 실행한다.
     */
    private void playOneRound() {
        outputView.printMessage(OutputMessage.ASK_MOVING);
        String moving = askUntilGetLegalAnswer(inputView::readMoving);
        bridgeGame.move(moving);
        movingMap.addOneRound(bridgeGame.hasPlayerFailed(), moving);
        outputView.printMap(movingMap);
    }

    /**
     * 사용자의 선택에 따라 게임을 재시도하거나 종료한다.
     */
    private void retryOrQuit() {
        outputView.printMessage(OutputMessage.ASK_RETRY_OR_QUIT);
        boolean toRetry = askUntilGetLegalAnswer(inputView::readGameCommand);
        if (toRetry) {
            bridgeGame.retry();
            movingMap = new MovingMap();
            playRoundsUntilFailOrDone();
        }
    }

    /**
     * 최종 결과를 출력한다.
     */
    private void showResult() {
        outputView.printMessage(OutputMessage.SHOW_RESULT);
        outputView.printMap(movingMap);
        outputView.printResult(bridgeGame.hasPlayerFailed(), bridgeGame.getTrialCount());
    }

    /**
     * 사용자에게 입력값을 받는다.
     * 잘못된 입력값으로 인한 예외 발생 시 다시 입력값을 받는다.
     */
    private <T> T askUntilGetLegalAnswer(Supplier<T> readInput) {
        try {
            return readInput.get();
        } catch (IllegalArgumentException exception) {
            outputView.printUserInputErrorMessage(exception.getMessage());
            return askUntilGetLegalAnswer(readInput);
        }
    }

    /**
     * 사용자에게 정해진 범위 내의 입력값을 받는다.
     * 잘못된 입력값으로 인한 예외 발생 시 다시 입력값을 받는다.
     */
    private <R> R askUntilGetLegalAnswer(BiFunction<Integer, Integer, R> readInput,
                                         int minimum, int maximum) {
        try {
            return readInput.apply(minimum, maximum);
        } catch (IllegalArgumentException exception) {
            outputView.printUserInputErrorMessage(exception.getMessage());
            return askUntilGetLegalAnswer(readInput, minimum, maximum);
        }
    }
}
