package bridge.io;

import bridge.GameResult;
import bridge.MoveCode;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String REQUEST_INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_INPUT_MOVE_CODE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_PRINT_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_YN_MESSAGE = "게임 성공 여부: ";
    private static final String RETRY_NUMBER_MESSAGE = "총 시도한 횟수: ";
    private static final String LEFT_BRACKET = "[ ";
    private static final String RIGHT_BRACKET = " ]";
    private static StringBuilder upStringBuilder = new StringBuilder();
    private static StringBuilder downStringBuilder = new StringBuilder();

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println(REQUEST_INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printRequestInputMoveCodeMessage() {
        System.out.println(REQUEST_INPUT_MOVE_CODE_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        StringBuilder mapStringBuilder = new StringBuilder();
        mapStringBuilder.append(upStringBuilder + "\n");
        mapStringBuilder.append(downStringBuilder);

        System.out.println(mapStringBuilder.toString().replace("][", "|"));
    }

    public void saveEachMap(MoveCode moveCode, String resultCode) {
        if(moveCode == MoveCode.DOWN) {
            upStringBuilder.append(LEFT_BRACKET + " " + RIGHT_BRACKET);
            downStringBuilder.append(LEFT_BRACKET + resultCode + RIGHT_BRACKET);
        }

        if(moveCode == MoveCode.UP) {
            upStringBuilder.append(LEFT_BRACKET + resultCode + RIGHT_BRACKET);
            downStringBuilder.append(LEFT_BRACKET + " " + RIGHT_BRACKET);
        }
    }

    public void printRequestInputGameCommandMessage() {
        System.out.println(REQUEST_INPUT_GAME_COMMAND_MESSAGE);
        upStringBuilder = new StringBuilder();
        downStringBuilder = new StringBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(GAME_RESULT_PRINT_MESSAGE);
        printMap();
        System.out.println(GAME_RESULT_YN_MESSAGE + gameResult.getGameResultCode().getResultMessage());
        System.out.println(RETRY_NUMBER_MESSAGE + gameResult.getRetryNumber());
    }

    public void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
