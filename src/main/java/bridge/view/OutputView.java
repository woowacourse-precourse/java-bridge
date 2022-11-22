package bridge.view;

import bridge.view.constant.ErrorMessage;
import bridge.view.constant.GameMapInterface;
import bridge.view.constant.GameMessage;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }
    public void printErrorMessage(ErrorMessage errorType) {
        System.out.println(errorType.getMessage());
    }

    public void printGameMessage(GameMessage messageType) {
        System.out.println(messageType.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upperMap, List<String> lowerMap) {
        System.out.println(transformToString(upperMap));
        System.out.println(transformToString(lowerMap));
        printEmptyLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean reachedEnd, int attempts) {
        System.out.println(getResultString(reachedEnd));
        System.out.println(getAttemptString(attempts));
    }

    public String transformToString(List<String> map) {
        StringJoiner stringJoiner = new StringJoiner(GameMapInterface.MAP_SEPARATOR.getValue());
        map.forEach(stringJoiner::add);
        return GameMapInterface.MAP_BRACKET.getBracketString(stringJoiner.toString());
    }

    public String getResultString(boolean reachedEnd) {
        StringBuilder stringBuilder = new StringBuilder(GameMessage.RESULT_BODY.getMessage());
        if (reachedEnd) {
            stringBuilder.append(GameMessage.SUCCESS.getMessage());
            return stringBuilder.toString();
        }
        stringBuilder.append(GameMessage.FAIL.getMessage());
        return stringBuilder.toString();
    }

    public String getAttemptString(int attempts) {
        return GameMessage.RESULT_ATTEMPTS.getMessage() + attempts;
    }
}
