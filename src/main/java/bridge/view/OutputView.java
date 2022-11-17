package bridge.view;

import bridge.model.BridgeGame;

public class OutputView {
    private static final int INCORRECT = 0;
    private static final int CORRECT = 1;
    private static final int RESULT_CORRECT = 2;


    public void printMap(BridgeGame game, int isCollect) {
        if (isCollect == CORRECT) {
            correctPrintMap(game);
        }
        if (isCollect == INCORRECT) {
            incorrectPrintMap(game);
        }
        if (isCollect == RESULT_CORRECT) {
            game.backForResult();
            correctPrintMap(game);
        }
    }

    private void correctPrintMap(BridgeGame game) {
        System.out.println(makeLine(game, "UP"));
        System.out.println(makeLine(game, "DOWN"));
        System.out.println();
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
            line += LineType.valueOf(type).getValue3();
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
        System.out.println(makeLine(game, "UP_FAIL"));
        System.out.println(makeLine(game, "DOWN_FAIL"));
        System.out.println();
    }

    public void printResult(BridgeGame game, int winType) {
        System.out.println(PrintSentence.GAME_RESULT.getSentence());
        distinguishWinType(game, winType);
        System.out.println(PrintSentence.RESULT.getSentence() + String.valueOf(game.getRetryCount()));
    }

    private void distinguishWinType(BridgeGame game, int winType) {
        if (winType == 1) {
            printMap(game,RESULT_CORRECT);
            System.out.println(PrintSentence.WIN.getSentence());
        }
        if (winType == 0) {
            printMap(game,INCORRECT);
            System.out.println(PrintSentence.LOSE.getSentence());
        }
    }
}
