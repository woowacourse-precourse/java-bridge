package bridge.views;

import bridge.messages.InputMessage;
import bridge.messages.ResultMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String upperSideCharacter = "U";
    private final String lowerSideCharacter = "D";
    private final String mapPrefix = "[";
    private final String mapPostfix = "]";
    private final String oneSpace = " ";
    private final String mapDelimiter = "|";
    private final String correctMark = "O";
    private final String wrongMark = "X";
    private final boolean succeed = true;
    private final boolean notSucceed = false;

    /**
     * 게임을 시작하는 메시지를 출력한다.
     */
    public void printStartMessage() {
        System.out.println(InputMessage.START_MESSAGE.getMessage());
    }

    /**
     * 다리의 길이를 입력하기 위한 안내 메시지를 출력한다.
     */
    public void printBridgeSizeInputMessage() {
        System.out.println();
        System.out.println(InputMessage.BRIDGE_SIZE_INPUT_MESSAGE.getMessage());
    }

    /**
     * 입력 중 발생한 오류를 출력한다.
     * @param errorMessage
     */
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * 다리를 건널 때, 위쪽으로 건널지 아래쪽으로 건널지
     * 선택하기 위한 안내 메시지를 출력한다.
     */
    public void printChooseMovingInputMessage() {
        System.out.println(InputMessage.MOVE_DIRECTION_INPUT_MESSAGE.getMessage());
    }

    /**
     * 게임에 실패 했을 때, 재시도 여부를 입력하기 위한
     * 안내 메시지를 출력한다.
     */
    public void printRetryInputMessage() {
        System.out.println(InputMessage.RETRY_INPUT_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 윗줄과 아랫줄을 각각 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moves, List<String> bridge) {
        printOneSideMap(upperSideCharacter, moves, bridge);
        printOneSideMap(lowerSideCharacter, moves, bridge);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 매개변수에 따라 윗줄이나 아랫줄을 출력한다.
     * <p>
     * 앞칸과 뒷칸을 나누는 '|' 구분자 때문에
     * 마지막의 이동한 다리와 그 이전의 이동을 따로 출력한다.
     * @param side
     * @param moves
     * @param bridge
     */
    private void printOneSideMap(String side, List<String> moves, List<String> bridge) {
        int lastMovePosition = moves.size() - 1;
        System.out.print(mapPrefix);
        for (int i = 0; i < lastMovePosition; ++i) {
            System.out.print(getOneBlockFormat(side, bridge.get(i)) + mapDelimiter);
        }
        System.out.print(getLastBlockFormat(side, moves.get(lastMovePosition), bridge.get(lastMovePosition)));
        System.out.println(mapPostfix);
    }

    /**
     * 마지막 이동을 제외한 이동의 출력 형식을 반한환다.
     * <p>
     * 이전의 이동들은 제대로된 이동인지 검사했기 때문에
     * 단순하게 길을 표시하는 형식을 반환할 수 있다.
     * @param side
     * @param direction
     * @return 다리 한칸의 출력 형식
     */
    private String getOneBlockFormat(String side, String direction) {
        if (side.equals(direction)) {
            return oneSpace + correctMark + oneSpace;
        }
        return oneSpace + oneSpace + oneSpace;
    }

    /**
     * 마지막으로 이동한 칸의 출력형식을 반환한다.
     * @param side
     * @param movedDirection
     * @param answerDirection
     * @return 마지막 칸의 이동 출력 형식
     */
    private String getLastBlockFormat(String side, String movedDirection, String answerDirection) {
        if (!side.equals(movedDirection)) {
            return oneSpace + oneSpace + oneSpace;
        }
        if (movedDirection.equals(answerDirection)) {
            return oneSpace + correctMark + oneSpace;
        }
        return oneSpace + wrongMark + oneSpace;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> moves, List<String> bridge, int tryCount) {
        System.out.println(ResultMessage.FINAL_GAME_RESULT_MAP.getMessage());
        printMap(moves, bridge);
        boolean succeeded = isSucceeded(moves, bridge);
        System.out.println(getSuccessOrFailMessage(succeeded));
        System.out.println(ResultMessage.TRY_COUNT_MESSAGE.getMessage() + tryCount);
    }

    /**
     * 게임의 최종 결과를 출력하기 위해 다리를 잘 건넜는지 확인한다.
     * @param moves
     * @param bridge
     * @return 성공여부를 반환한다.
     */
    private boolean isSucceeded(List<String> moves, List<String> bridge) {
        if (moves.size() != bridge.size()) {
            return notSucceed;
        }
        for (int i = 0; i < moves.size(); ++i) {
            if (!moves.get(i).equals(bridge.get(i))) {
                return notSucceed;
            }
        }
        return succeed;
    }

    /**
     * 게임의 최종 결과를 출력하기 위해 성공여부에 따른 메시지를 얻는다.
     * @param succeeded
     * @return 성공 여부에 따른 메시지를 반환한다.
     */
    private String getSuccessOrFailMessage(boolean succeeded) {
        if (succeeded) {
            return ResultMessage.SUCCESS.getMessage();
        }
        return ResultMessage.FAIL.getMessage();
    }
}
