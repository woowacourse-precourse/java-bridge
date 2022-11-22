package bridge;

import bridge.enummodel.GameResultEnum;
import bridge.enummodel.MessageEnum;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int upSide = 0;
    private static final int downSide = 1;
    private static final String leftBracket = "\\[";
    private static final String rightBracket = "]";
    private static final String space = " ";
    private static final String comma = ",";
    private static final String verticalBar = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upAnswer, List<String> downAnswer) {
        convertResult(upAnswer);
        convertResult(downAnswer);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> result, int retryNumber, Boolean gameResult) {
        System.out.println(MessageEnum.GAME_END_INFO.getValue());
        printMap(result.get(upSide), result.get(downSide));
        System.out.println(MessageEnum.GAME_RESULT.getValue() + GameResultEnum.RESULT.getValue(gameResult));
        System.out.println(MessageEnum.GAME_TRY.getValue() + retryNumber);
    }

    public void initGame() {
        System.out.println(MessageEnum.GAME_START.getValue());
    }

    private void convertResult(List<String> upAnswer) {
        System.out.println(String.valueOf(upAnswer)
                .replaceAll(comma, space + verticalBar)
                .replaceAll(leftBracket, leftBracket + space)
                .replaceAll(rightBracket, space + rightBracket));
    }
}
