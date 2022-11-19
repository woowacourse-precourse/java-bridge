package bridge.view;

import bridge.MoveDirection;
import bridge.Result;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_IS_SUCCEED_MESSAGE = "\n게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        printFirstBridge(result);
        printSecondBridge(result);
    }

    private void printFirstBridge(Result result) {
        StringBuilder sb = new StringBuilder();
        printOpenSquareBracket(sb);
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();
        for (int i = 0; i < isAnswers.size(); i++) {
            if (result.isDownSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isDownSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isUpSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("O");
            }
            if (result.isUpSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("X");
            }
            if (i < isAnswers.size() - 1) {
                sb.append(" | ");
            }
        }
        printCloseSquareBracket(sb);
        System.out.print(sb);
    }

    private void printSecondBridge(Result result) {
        StringBuilder sb = new StringBuilder();
        printOpenSquareBracket(sb);
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();
        for (int i = 0; i < isAnswers.size(); i++) {
            if (result.isUpSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isUpSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isDownSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("O");
            }
            if (result.isDownSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("X");
            }
            if (i < isAnswers.size() - 1) {
                sb.append(" | ");
            }
        }
        printCloseSquareBracket(sb);
        System.out.print(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(GAME_RESULT_MESSAGE);
        // 게임 결과 출력!

    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMoveDirection() {
        System.out.println(INPUT_MOVE_DIRECTION_MESSAGE);
    }

    public void printInputGameRetry() {
        System.out.println(INPUT_GAME_RETRY_MESSAGE);
    }

    private void printOpenSquareBracket(StringBuilder sb) {
        sb.append("[ ");
    }

    private void printCloseSquareBracket(StringBuilder sb) {
        sb.append(" ]")
          .append("\n");
    }
}
