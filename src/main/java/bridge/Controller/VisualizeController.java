package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.View.UiMessage;

public class VisualizeController {
    private VisualizeController(BridgeGame bridgeGame) {
        StringBuilder upperSubstring = new StringBuilder(bridgeGame.upperResult.replaceFirst("]", ""));
        StringBuilder lowerSubstring = new StringBuilder(bridgeGame.lowerResult.replaceFirst("]", ""));
        drawGraph(bridgeGame, upperSubstring, lowerSubstring);
        bridgeGame.upperResult = upperSubstring.toString();
        bridgeGame.lowerResult = lowerSubstring.toString();
    }

    private void drawGraph(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.idx > 0) {
            drawGraphAfterFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
            return;
        }
        drawGraphOfFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
    }

    private void drawGraphOfFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals(bridgeGame.bridge.get(bridgeGame.idx))) {
            addCorrectToGraphFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
            return;
        }
        addIncorrectToGraphFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
    }

    private void addIncorrectToGraphFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals("U")) {
            upperSubstring.append(UiMessage.FIRST_X.getValue());
            lowerSubstring.append(UiMessage.FIRST_BLANK.getValue());
            return;
        }
        upperSubstring.append(UiMessage.FIRST_BLANK.getValue());
        lowerSubstring.append(UiMessage.FIRST_X.getValue());
    }

    private void addCorrectToGraphFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals("U")) {
            upperSubstring.append(UiMessage.FIRST_O.getValue());
            lowerSubstring.append(UiMessage.FIRST_BLANK.getValue());
            return;
        }
        upperSubstring.append(UiMessage.FIRST_BLANK.getValue());
        lowerSubstring.append(UiMessage.FIRST_O.getValue());
    }

    private void drawGraphAfterFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals(bridgeGame.bridge.get(bridgeGame.idx))) {
            addCorrectToGraphAfterFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
            return;
        }
        addIncorrectToGraphAfterFirstProgress(bridgeGame, upperSubstring, lowerSubstring);
    }

    private void addIncorrectToGraphAfterFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals("U")) {
            upperSubstring.append(UiMessage.X_AFTER_FIRST.getValue());
            lowerSubstring.append(UiMessage.BLACK_AFTER_FIRST.getValue());
            return;
        }
        upperSubstring.append(UiMessage.BLACK_AFTER_FIRST.getValue());
        lowerSubstring.append(UiMessage.X_AFTER_FIRST.getValue());
    }

    private void addCorrectToGraphAfterFirstProgress(BridgeGame bridgeGame, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (bridgeGame.user.get(bridgeGame.idx).equals("U")) {
            upperSubstring.append(UiMessage.O_AFTER_FIRST.getValue());
            lowerSubstring.append(UiMessage.BLACK_AFTER_FIRST.getValue());
            return;
        }
        upperSubstring.append(UiMessage.BLACK_AFTER_FIRST.getValue());
        lowerSubstring.append(UiMessage.O_AFTER_FIRST.getValue());
    }

    public static void getVisualizeController(BridgeGame bridgeGame){
        new VisualizeController(bridgeGame);
    }
}
