package bridge.view;

import bridge.model.BridgeGame;

public class OutputView {
    private static final int INCORRECT = 0;
    private static final int CORRECT = 1;

    public void printMap(BridgeGame game, int isCollect) {
        if (isCollect == CORRECT) {
            correctPrintMap(game);
        }
        if (isCollect == INCORRECT) {
            incorrectPrintMap(game);
        }
    }

    private void correctPrintMap(BridgeGame game) {
        System.out.println(makeLine(game, "UP"));
        System.out.println(makeLine(game, "DOWN"));
    }

    private String makeLine(BridgeGame game, String type) {
        String Line = PrintSentence.LEFT_WALL.getSentence();
        for (int i = 0; i < game.getNowPosition() + 1; i++) {
            Line += checkUpOrNot(game, i, type);
            Line += checkLast(game, i);
        }
        Line += PrintSentence.RIGHT_WALL.getSentence();
        return Line;
    }

    private String checkUpOrNot(BridgeGame game, int index, String type) {
        String line = "";
        if (game.getBridge().get(index).equals(LineType.valueOf(type).getValue1())) {
            line += PrintSentence.CORRECT.getSentence();
        }
        if (game.getBridge().get(index).equals(LineType.valueOf(type).getValue2())) {
            line += " ";
        }
        return line;
    }
    private String checkLast(BridgeGame game, int index) {
        if (index < game.getNowPosition()) {
            return PrintSentence.MIDDLE_WALL.getSentence();
        }
        return "";
    }


    private void incorrectPrintMap(BridgeGame game) {

    }

    public void printResult(BridgeGame game, int winType) {
        if (winType == 1) {
            System.out.println(PrintSentence.WIN.getSentence());
        }
        if (winType == 0) {
            System.out.println(PrintSentence.LOSE.getSentence());
        }
        System.out.println(PrintSentence.RESULT.getSentence() + String.valueOf(game.getRetryCount()));
    }
}
