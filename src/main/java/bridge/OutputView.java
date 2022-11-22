package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    BridgeGame bridgeGame;
    Boolean moved;

    public void printMap(BridgeGame bridgeGame, Boolean moved) {
        this.bridgeGame = bridgeGame;
        this.moved = moved;
        List<String> currentBridge = bridgeGame.getCurrentBridge();
        List<String> upperRow = convertUpperRow(currentBridge, moved);
        List<String> lowerRow = convertLowerRow(currentBridge, moved);
        System.out.println(addDelimiter(upperRow));
        System.out.println(addDelimiter(lowerRow));
        System.out.println();
    }

    public List<String> convertUpperRow(List<String> currentBridge, Boolean moved) {
        List<String> upperRow = new ArrayList<>();
        for (String bridge : currentBridge) {
            if (bridge.equals(Constant.UP)) {
                upperRow.add(Constant.BRIDGE_RIGHT);
                continue;
            }
            upperRow.add(Constant.BRIDGE_BLANK);
        }
        if (!moved) {
            return markLastElement(upperRow);
        }
        return upperRow;
    }

    public List<String> convertLowerRow(List<String> currentBridge, Boolean moved) {
        List<String> lowerRow = new ArrayList<>();
        for (String bridge : currentBridge) {
            if (bridge.equals(Constant.DOWN)) {
                lowerRow.add(Constant.BRIDGE_RIGHT);
                continue;
            }
            lowerRow.add(Constant.BRIDGE_BLANK);
        }
        if (!moved) {
            return markLastElement(lowerRow);
        }
        return lowerRow;
    }

    public List<String> markLastElement(List<String> row) {
        if (row.get(row.size() - 1).equals(Constant.BRIDGE_BLANK)) {
            row.set(row.size() - 1, Constant.BRIDGE_WRONG);
            return row;
        }
        row.set(row.size() - 1, Constant.BRIDGE_BLANK);
        return row;
    }

    public String addDelimiter(List<String> row) {
        return Constant.BRIDGE_START + String.join(Constant.BRIDGE_DELIMITER, row) + Constant.BRIDGE_END;
    }

    public void printResult(String result, Integer attempt) {
        System.out.println(Constant.PRINT_RESULT);
        printMap(this.bridgeGame, this.moved);
        System.out.println(Constant.GAME_RESULT + result);
        System.out.println(Constant.ATTEMPT + attempt);
    }
}
