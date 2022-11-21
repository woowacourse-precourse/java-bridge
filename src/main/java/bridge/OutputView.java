package bridge;

import enumCollections.GameStatus;
import enumCollections.GuideMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map map) {
        map.get().stream()
                .forEach(line -> {
                    System.out.print("[ ");
                    System.out.print(String.join(" | ", line));
                    System.out.print(" ]\n");
                });
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus) {
        printGuideMessage(GuideMessage.GAME_RESULT ,GameStatus.get(gameStatus));
    }

    public void printAskGameCommand() {
        printGuideMessage(GuideMessage.GET_GAME_COMMAND);
    }

    public void printGuideMessage(GuideMessage situation) {
        System.out.println(GuideMessage.get(situation));
    }

    public void printGuideMessage(GuideMessage situation, String gameStatus) {
        System.out.printf(GuideMessage.get(situation), gameStatus);
    }

    public void printNewline() {
        System.out.println();
    }
}
