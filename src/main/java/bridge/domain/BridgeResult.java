package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private static final String EMPTY = "   ";
    private static final String CORRECT_ANSWER = " O ";
    private static final String WRONG_ANSWER = " X ";

    private final List<String> answerBridge;

    public BridgeResult(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public String matchBridge(List<String> playerBridge) {
        StringBuilder sb = new StringBuilder();
        String upBridge = createLine(playerBridge, "U");
        String downBridge = createLine(playerBridge, "D");
        sb.append(upBridge + "\n" + downBridge);
        return sb.toString();
    }

    private String createLine(List<String> playerBridge, String position) {
        List<String> line = new ArrayList<>();
        matchLine(line, playerBridge, position);
        String[] array = new String[line.size()];
        int size=0;
        for(String temp : line){
            array[size++] = temp;
        }
        return line.toString().replaceAll(", ", "|");
    }

    private void matchLine(List<String> line, List<String> playerBridge, String position) {
        for (int i = 0; i < playerBridge.size(); i++) {
            if (answerBridge.get(i).equals(position)) {
                addScore(line, playerBridge.get(i), answerBridge.get(i));
                continue;
            }
            line.add(EMPTY);
        }
    }

    private void addScore(List<String> line, String player, String answer) {
        if (answer.equals(player)) {
            line.add(CORRECT_ANSWER);
            return;
        }
        line.add(WRONG_ANSWER);
    }

}
