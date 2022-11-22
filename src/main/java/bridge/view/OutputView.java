package bridge.view;

import bridge.constant.BridgeDirection;
import bridge.constant.OutputMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(OutputMessage.BRIDGE_GAME_START.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeDirections, List<String> userMoveHistory) {
        String upDirectionMap = makeUpDirectionMap(bridgeDirections, userMoveHistory);
        String downDirectionMap = makeDownDirectionMap(bridgeDirections, userMoveHistory);
        System.out.println(convertToPrintFormat(upDirectionMap));
        System.out.println(convertToPrintFormat(downDirectionMap));
    }

    private String makeUpDirectionMap(List<String> bridgeDirections, List<String> userMoveHistory) {
        List<String> map = new ArrayList<>();
        for (int moveHistoryIndex = 0; moveHistoryIndex < userMoveHistory.size(); moveHistoryIndex++) {
            if (!bridgeDirections.get(moveHistoryIndex).equals(BridgeDirection.UP.getFirstLetter())) {
                map.add(OutputMessage.EMPTY_SPACING.getMessage());
                continue;
            }
            map.add(makeStatus(bridgeDirections.get(moveHistoryIndex), userMoveHistory.get(moveHistoryIndex)));
        }
        return map.toString();
    }

    private String makeDownDirectionMap(List<String> bridgeDirections, List<String> userMoveHistory) {
        List<String> map = new ArrayList<>();
        for (int moveHistoryIndex = 0; moveHistoryIndex < userMoveHistory.size(); moveHistoryIndex++) {
            if (!bridgeDirections.get(moveHistoryIndex).equals(BridgeDirection.DOWN.getFirstLetter())) {
                map.add(OutputMessage.EMPTY_SPACING.getMessage());
                continue;
            }
            map.add(makeStatus(bridgeDirections.get(moveHistoryIndex), userMoveHistory.get(moveHistoryIndex)));
        }
        return map.toString();
    }

    private String makeStatus(String bridgeDirection, String userDirection) {
        if (userDirection.equals(bridgeDirection)) {
            return OutputMessage.MOVE_SUCCESS.getMessage();
        }
        return OutputMessage.MOVE_FAIL.getMessage();
    }

    private String convertToPrintFormat(String output) {
        output = openBracketConvertToPrintFormat(output);
        output = convertToSeparator(output);
        return closeBracketConvertToPrintFormat(output);
    }

    private String openBracketConvertToPrintFormat(String output) {
        return output.replaceAll(
                OutputMessage.OPEN_BRACKET.getMessage(),
                OutputMessage.OPEN_BRACKET.getMessage() + OutputMessage.EMPTY_SPACING.getMessage()
        );
    }

    private String convertToSeparator(String output) {
        return output.replaceAll(
                OutputMessage.COMMA.getMessage(),
                OutputMessage.EMPTY_SPACING.getMessage() + OutputMessage.SEPARATOR.getMessage()
        );
    }

    private String closeBracketConvertToPrintFormat(String output) {
        return output.replaceAll(
                OutputMessage.CLOSE_BRACKET.getMessage(),
                OutputMessage.EMPTY_SPACING.getMessage() + OutputMessage.CLOSE_BRACKET.getMessage()
        );
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Integer tryCount, List<String> bridgeDirections, List<String> userMoveHistory) {
        System.out.println(OutputMessage.GAME_FINAL_RESULT.getMessage());
        printMap(bridgeDirections, userMoveHistory);
        System.out.println(
                OutputMessage.FINAL_SUCCESS_STATUS.getMessage()
                        + OutputMessage.convertToFinalStatus(bridgeDirections.equals(userMoveHistory))
        );
        System.out.println(OutputMessage.NUMBER_OF_GAME_TRY.getMessage() + tryCount);
    }
}
