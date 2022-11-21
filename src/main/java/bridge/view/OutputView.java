package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_OVER = "최종 게임 결과";

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_PLAYER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_PLAYER_COMMAND =
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + GameCommand.RETRY.getCode() + ", 종료: " + GameCommand.QUIT.getCode() + ")";

    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";

    private void print(String printString) {
        System.out.println(printString);
    }

    public void printNewline() {
        print("");
    }

    public void printGameStart() {
        print(GAME_START);
        printNewline();
    }

    public void printGameOver() {
        print(GAME_OVER);
    }

    public void inputBridgeSize() {
        print(INPUT_BRIDGE_SIZE);
    }

    public void inputPlayerMove() {
        print(INPUT_PLAYER_MOVE);
    }

    public void inputPlayerCommand() {
        print(INPUT_PLAYER_COMMAND);
    }

    public void printMap(String result) {
        print(result);
        printNewline();
    }

    public void printResult(GameStatus gameStatus, int numberOfAttempts) {
        print(GAME_SUCCESS_OR_NOT + gameStatus.getStatus());
        print(TOTAL_NUMBER_OF_ATTEMPTS + numberOfAttempts);
    }
}
