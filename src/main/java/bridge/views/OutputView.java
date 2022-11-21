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

    public void printStartMessage() {
        System.out.println(InputMessage.START_MESSAGE.getMessage());
    }

    public void printBridgeSizeInputMessage() {
        System.out.println();
        System.out.println(InputMessage.BRIDGE_SIZE_INPUT_MESSAGE.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printChooseMovingInputMessage() {
        System.out.println(InputMessage.MOVE_DIRECTION_INPUT_MESSAGE.getMessage());
    }

    public void printRetryInputMessage() {
        System.out.println();
        System.out.println(InputMessage.RETRY_INPUT_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moves, List<String> bridge) {
        printOneSideMap(upperSideCharacter, moves, bridge);
        printOneSideMap(lowerSideCharacter, moves, bridge);
        System.out.println();
    }

    private void printOneSideMap(String side, List<String> moves, List<String> bridge) {
        int lastMovePosition = moves.size() - 1;
        System.out.print(mapPrefix);
        for (int i = 0; i < lastMovePosition; ++i) {
            System.out.print(oneSpace + getOneBlockFormat(side, bridge.get(i)) + oneSpace + mapDelimiter);
        }
        System.out.print(getLastBlockFormat(side, moves.get(lastMovePosition), bridge.get(lastMovePosition)));
        System.out.println(mapPostfix);
    }

    private String getOneBlockFormat(String side, String direction) {
        if (side.equals(direction)) {
            return correctMark;
        }
        return oneSpace;
    }

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

    private String getSuccessOrFailMessage(boolean succeeded) {
        if (succeeded) {
            return ResultMessage.SUCCESS.getMessage();
        }
        return ResultMessage.FAIL.getMessage();
    }
}
