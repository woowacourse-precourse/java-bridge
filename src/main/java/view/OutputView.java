package view;

import bridge.Map;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;

public class OutputView {
    public void printMap(Map map) {
        map.get().stream()
                .forEach(line -> {
                    System.out.print("[ ");
                    System.out.print(String.join(" | ", line));
                    System.out.print(" ]\n");
                });
    }

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

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
