package bridge.ui;

import bridge.domain.User;

import java.util.List;

import static bridge.domain.bridgemaking.Space.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_TO_GET_SIZE = "다리의 길이를 입력해 주세요.";
    private static final String MESSAGE_TO_GET_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MESSAGE_TO_PRINT_RESULT = "\n최종 게임 결과";
    private static final String WHETHER_SUCCEED_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCEEDED_MESSAGE = "성공";
    private static final String FAILED_MESSAGE = "실패";
    private static final String THE_NUMBER_OF_TRIAL = "총 시도한 횟수: ";

    // 시작 메시지, 다리 길이를 입력받기 위한 메시지 출력
    public void printInitialMessages() {
        System.out.println(STARTING_MESSAGE);
        System.out.println(MESSAGE_TO_GET_SIZE);
    }

    // 이동할 칸을 입력받기 위한 메시지 출력
    public void printMessageToGetSpaceToMove() {
        System.out.println(MESSAGE_TO_GET_SPACE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        List<String> up = user.getCurrentBridge().get(UP.getIndex());
        List<String> down = user.getCurrentBridge().get(DOWN.getIndex());

        up.forEach(System.out::print);
        System.out.println();
        down.forEach(System.out::print);
        System.out.print("\n\n");
    }

    // 재시도 여부를 입력받기 위한 메시지 출력
    public void printMessageAfterFailure() {
        System.out.println(MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println(MESSAGE_TO_PRINT_RESULT);
        printMap(user);
        printSucceedOrFailed(user);
        System.out.print(THE_NUMBER_OF_TRIAL + user.getTheNumOfTrials());
    }

    private static void printSucceedOrFailed(User user) {
        System.out.print(WHETHER_SUCCEED_OR_NOT);
        if (user.getSucceeded()) {
            System.out.println(SUCCEEDED_MESSAGE);
            return;
        }
        System.out.println(FAILED_MESSAGE);
    }

}
