package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String leftBracket = "[";
    private final String rightBracket = "]";
    private final String FinalGameResultMessage = "최종 게임 결과";
    private final String GameResultIsSuccess = "게임 성공 여부: 성공";
    private final String GameResultIsFail = "게임 성공 여부: 실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridges) {
        System.out.println(leftBracket + String.join("|", bridges) + rightBracket);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> upperBridges, List<String> lowerBridges) {
        System.out.println(FinalGameResultMessage);
        printMap(upperBridges);
        printMap(lowerBridges);
    }

    public void printResultMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(GameResultIsSuccess);
        }
        if (!isSuccess) {
            System.out.println(GameResultIsFail);
        }
    }
}
