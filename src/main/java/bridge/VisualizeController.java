package bridge;

import bridge.Model.BridgeGame;

public class VisualizeController {
    public VisualizeController(int idx) { // 지금 몇번째 판떼기에 있는지 받아와서 갱신하는 방식으로 바꾸기
        StringBuilder upperSubstring = new StringBuilder(BridgeGame.upperResult.replaceFirst("]", ""));
        StringBuilder lowerSubstring = new StringBuilder(BridgeGame.lowerResult.replaceFirst("]", ""));
        drawGraph(idx, upperSubstring, lowerSubstring);
        BridgeGame.upperResult = upperSubstring.toString();
        BridgeGame.lowerResult = lowerSubstring.toString();
    }

    private static void drawGraph(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (idx > 0) {
            drawGraphAfterFirstProgress(idx, upperSubstring, lowerSubstring);
            return;
        }
        drawGraphOfFirstProgress(idx, upperSubstring, lowerSubstring);
    }

    private static void drawGraphOfFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals(BridgeGame.bridge.get(idx))) {
            addCorrectToGraphFirstProgress(idx, upperSubstring, lowerSubstring);
            return;
        }
        addIncorrectToGraphFirstProgress(idx, upperSubstring, lowerSubstring);
    }

    private static void addIncorrectToGraphFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals("U")) {
            upperSubstring.append(" X ]");
            lowerSubstring.append("   ]");
            return;
        }
        upperSubstring.append("   ]");
        lowerSubstring.append(" X ]");
    }

    private static void addCorrectToGraphFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals("U")) {
            upperSubstring.append(" O ]");
            lowerSubstring.append("   ]");
            return;
        }
        upperSubstring.append("   ]");
        lowerSubstring.append(" O ]");
    }

    private static void drawGraphAfterFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals(BridgeGame.bridge.get(idx))) {
            addCorrectToGraphAfterFirstProgress(idx, upperSubstring, lowerSubstring);
            return;
        }
        addIncorrectToGraphAfterFirstProgress(idx, upperSubstring, lowerSubstring);
    }

    private static void addIncorrectToGraphAfterFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals("U")) {
            upperSubstring.append("| X ]");
            lowerSubstring.append("|   ]");
            return;
        }
        upperSubstring.append("|   ]");
        lowerSubstring.append("| X ]");
    }

    private static void addCorrectToGraphAfterFirstProgress(int idx, StringBuilder upperSubstring, StringBuilder lowerSubstring) {
        if (BridgeGame.user.get(idx).equals("U")) {
            upperSubstring.append("| O ]");
            lowerSubstring.append("|   ]");
            return;
        }
        upperSubstring.append("|   ]");
        lowerSubstring.append("| O ]");
    }
}
