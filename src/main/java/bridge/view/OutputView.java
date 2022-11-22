package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.MakeLine;

public class OutputView {
    private static final int INCORRECT = 0;
    private static final int CORRECT = 1;
    private static final int RESULT_CORRECT = 2;
    private MakeLine makeLine = new MakeLine();

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
        System.out.println(makeLine.makeLine(game, "UP"));
        System.out.println(makeLine.makeLine(game, "DOWN"));
        System.out.println();
    }

    private void incorrectPrintMap(BridgeGame game) {
        System.out.println(makeLine.makeLineIncorrect(game, "UP"));
        System.out.println(makeLine.makeLineIncorrect(game, "DOWN"));
        System.out.println();
    }

    public void printResult(BridgeGame game, int winType) {
        System.out.println(PrintSentence.GAME_RESULT.getSentence());
        distinguishWinType(game, winType);
        System.out.println(PrintSentence.RESULT.getSentence() + String.valueOf(game.getRetryCount()));
    }

    private void distinguishWinType(BridgeGame game, int winType) {
        if (winType == 1) {
            printMap(game, RESULT_CORRECT);
            System.out.println(PrintSentence.WIN.getSentence());
        }
        if (winType == 0) {
            printMap(game, INCORRECT);
            System.out.println(PrintSentence.LOSE.getSentence());
        }
    }
}
