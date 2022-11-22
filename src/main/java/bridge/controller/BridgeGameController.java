package bridge.controller;

import bridge.BridgeMaker;
import bridge.config.LoopActivity;
import bridge.config.ErrorMessageConstant;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeTranslator;
import bridge.domain.model.Direction;
import bridge.domain.model.GameStatus;
import bridge.view.BridgeConsoleTranslator;
import bridge.view.CommandType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 진행하기 위한 사용자와의 상호작용과 게임의 전체적인 흐름을 담당한다.
 */
public class BridgeGameController extends LoopActivity {

    private final BridgeTranslator bridgeTranslator = new BridgeConsoleTranslator();
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        validationConstructorParams();
    }


    @Override
    protected final void onStart() {
        outputView.printGameStart();
        executeUntilNoException(() -> createBridgeGame(readBridgeSize()));
    }

    @Override
    protected final void onLoop() {
        while (bridgeGame.getStatus() == GameStatus.RUNNING) {
            executeUntilNoException(this::proceedTurn);
        }
        if (bridgeGame.getStatus() == GameStatus.LOSE) {
            if (executeUntilNoException(this::enterRetry)) {
                bridgeGame.retry();
                return;
            }
        }
        stop();
    }

    @Override
    protected final void onStop() {
        outputView.printResult(bridgeGame, bridgeTranslator);
    }

    @Override
    protected void onError(Exception e) {
        if (e instanceof IllegalArgumentException) {
            outputView.printExpectedErrorMessage((IllegalArgumentException) e);
            return;
        }
        outputView.printUnexpectedErrorMessage(e);
    }

    /**
     * 생성자에서 주입받은 객체들의 유효성 검사
     * @throws IllegalArgumentException null이 포함되면 예외 발생
     */
    private void validationConstructorParams() throws IllegalArgumentException {
        if (this.bridgeMaker == null || inputView == null || outputView == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.PARAMS_HAVE_NULL_VALUE);
        }
    }

    /**
     * 사용자로부터 다리의 길이를 입력 받는다.
     * @return 다리의 길이
     * @throws IllegalArgumentException 올바르지 않은 입력에 대해 예외 발생
     */
    private int readBridgeSize() throws IllegalArgumentException {
        outputView.printEnterBridgeLength();
        return inputView.readBridgeSize();
    }

    /**
     * 다리 건너기 게임을 생성한다.
     * @param bridgeSize 다리의 길이
     * @throws IllegalArgumentException 범위를 벗어난 다리의 길이에 대해 예외 발생
     */
    private void createBridgeGame(int bridgeSize) throws IllegalArgumentException {
        List<String> bridgeInfo = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(bridgeInfo);
        bridgeGame = new BridgeGame(bridge);
    }

    /**
     * 게임 재시작 여부를 입력받는다.
     * @return 재시작 여부
     * @throws IllegalArgumentException 올바르지 않은 명령어에 대해 예외 발생
     */
    private boolean enterRetry() throws IllegalArgumentException {
        outputView.printEnterGameRetry();
        CommandType command = inputView.readGameCommand();
        if (command == CommandType.GAME_QUIT) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    /**
     * 한 번의 턴을 진행한다.
     * <p>
     * 이동 방향을 입력 받고 다리 건너기를 수행한다.
     * <p>
     * 이동 후 현재 다리 건너기 상태를 표시한다.
     * @throws IllegalArgumentException 다리 건너기를 진행할 수 없는 상태이거나, 유효하지 않은 명령일 경우 예외 발생
     */
    private void proceedTurn() throws IllegalArgumentException {
        outputView.printEnterMoveDirection();
        Direction direction = mapToDirection(inputView.readMoving());
        moveToDirection(direction);
        outputView.printMap(bridgeGame, bridgeTranslator);
    }

    /**
     * 해당 방향으로 다리 건너기를 진행한다.
     * @param direction 건널 방향
     * @throws IllegalArgumentException 실패나 게임 성공으로 다리 건너기를 진행할 수 없는 경우 예외 발생
     */
    private void moveToDirection(Direction direction) throws IllegalArgumentException {
        try {
            bridgeGame.move(direction);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.GAME_STATUS_NOT_ALLOW_MOVE);
        }
    }

    /**
     * 명령어를 방향으로 변환한다.
     * @param commandType 명령어
     * @return 방향
     * @see CommandType
     * @see Direction
     */
    private static Direction mapToDirection(CommandType commandType) {
        return Direction.of(commandType.getCommand());
    }

}
