package bridge.view.outputview;

import bridge.system.util.BridgeMessageMaker;
import bridge.vo.*;
import bridge.vo.enums.Command;
import bridge.vo.enums.Step;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String GAME_STARTING_MESSAGE = String.format("다리 건너기 게임을 시작합니다.%n%n");
    public static final String ASKING_BRIDGE_SIZE_MESSAGE = String.format("다리의 길이를 입력해주세요.%n");
    public static final String ASKING_NEXT_STEP_MESSAGE
            = String.format("%n이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n", Step.U, Step.D);
    public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s 다시 입력해 주세요.%n";
    public static final String TRY_COUNT_MESSAGE_FORMAT = "총 시도한 횟수: %s";
    public static final String ASKING_GAME_COMMAND_MESSAGE
            = String.format("%n게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n", Command.R, Command.Q);
    public static final String GAME_RESULT_PREFIX = String.format("%n최종 게임 결과%n");
    public static final String GAME_SUCCESS_MESSAGE = String.format("%n게임 성공 여부: 성공%n");
    public static final String GAME_FAILURE_MESSAGE = String.format("%n게임 성공 여부: 실패%n");

    private final BridgeMessageMaker bridgeMessageMaker;

    public OutputView(BridgeMessageMaker bridgeMessageMaker) {
        this.bridgeMessageMaker = bridgeMessageMaker;
    }

    public void printGameStartMessage() {
        System.out.print(GAME_STARTING_MESSAGE);
    }

    public void printAskingBridgeSizeMessage() {
        System.out.print(ASKING_BRIDGE_SIZE_MESSAGE);
    }

    public void printAskingNextStepMessage() {
        System.out.print(ASKING_NEXT_STEP_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<StepResult> stepResults) {
        System.out.println(bridgeMessageMaker.makeBridgeMessage(stepResults));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult, boolean isFinished) {
        System.out.print(GAME_RESULT_PREFIX);
        printMap(gameResult.getStepResults());
        printIsFinished(isFinished);
        printTryCount(gameResult.getTryCount());
    }

    private void printIsFinished(boolean isFinished) {
        if (isFinished) {
            System.out.print(GAME_SUCCESS_MESSAGE);
        }
        if (!isFinished) {
            System.out.print(GAME_FAILURE_MESSAGE);
        }
    }

    private void printTryCount(TryCount tryCount) {
        System.out.printf(TRY_COUNT_MESSAGE_FORMAT, tryCount);
    }

    public void printAskingGameCommandMessage() {
        System.out.print(ASKING_GAME_COMMAND_MESSAGE);
    }

    public void printErrorMessage(Throwable e) {
        System.out.printf(ERROR_MESSAGE_FORMAT, e.getMessage());
    }
}
