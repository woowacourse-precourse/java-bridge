package bridge.view;

import bridge.domain.GameRecord;
import bridge.domain.GameRound;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String IS_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private static final String OPEN_PARENTHESIS = "[ ";
    private static final String CLOSE_PARENTHESIS = " ]";
    private static final String MIDDLE_PARENTHESIS = " | ";

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
        System.out.println();
    }

    public void printInputBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMoveCommand() {
        System.out.println(MOVE_COMMAND_MESSAGE);
    }

    public void printRetryCommand() {
        System.out.println(RETRY_COMMAND_MESSAGE);
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameRound gameRound) {
        List<List<String>> playedBridge = gameRound.getPlayedBridge();
        for (int i = 0; i < playedBridge.size(); i++) {
            List<String> bridge = playedBridge.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            makeBridgeResult(bridge, stringBuilder);
            System.out.println(stringBuilder);
        }
        System.out.println();
    }

    private void makeBridgeResult(List<String> bridge, StringBuilder stringBuilder) {
        stringBuilder.append(OPEN_PARENTHESIS);
        makeBridgeBody(bridge, stringBuilder);
        stringBuilder.append(CLOSE_PARENTHESIS);
    }

    private void makeBridgeBody(List<String> bridge, StringBuilder stringBuilder) {
        String body = String.join(MIDDLE_PARENTHESIS, bridge);
        stringBuilder.append(body);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameRound gameRound, GameRecord gameRecord) {
        System.out.println(FINAL_RESULT_MESSAGE);

        printMap(gameRound);

        System.out.println(IS_SUCCESS_MESSAGE);
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + gameRecord.getPlayTimes());
    }
}
