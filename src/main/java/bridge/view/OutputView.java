package bridge.view;

import bridge.domain.Direction;
import bridge.exception.ErrorMessage;
import bridge.game.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LF = System.lineSeparator();
    private static final String START_GAME = "게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH = "다리 길이를 입력해주세요.";
    private static final String SELECT_ROOM = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String DO_YOU_WANT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS = "게임 성공 여부: ";
    private static final String TRY_COUNT = "총 시도한 횟수: ";

    private OutputView() {

    }

    public static void startGame() {
        println(START_GAME);
    }

    public static void getBridgeLength() {
        print(INPUT_BRIDGE_LENGTH);
    }

    public static void selectRoom() {
        print(SELECT_ROOM);
    }

    public static void checkRestart() {
        print(DO_YOU_WANT_RESTART);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String map) {
        println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(GameStatus gameStatus, Direction direction) {
        println(GAME_RESULT + LF + gameStatus.getBridgeStatus());

        String status = GAME_STATUS + gameStatus.getStatus(direction) + LF;
        String count = TRY_COUNT + gameStatus.getTryCount();
        print(status + count);
    }

    public static void printErrorMessage(String message) {
        println(ErrorMessage.ERROR + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void println(String message) {
        System.out.println(message + LF);
    }

}
