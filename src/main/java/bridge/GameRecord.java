package bridge;

import bridge.enums.BridgeMapConstants;
import bridge.enums.GameCases;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameRecord {

    private static final List<GameCases> GAME_CASES = Stream.of(GameCases.values()).collect(Collectors.toList());

    private final List<String> moveRecord;
    private final List<Boolean> resultRecord;
    private int playTime;

    public GameRecord() {
        moveRecord = new ArrayList<>();
        resultRecord = new ArrayList<>();
        playTime = 0;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void addRecord(String move, boolean result) {
        moveRecord.add(move);
        resultRecord.add(result);
    }

    public String makeBridgeRecord() {
        StringBuilder upperRow = new StringBuilder();
        StringBuilder lowerRow = new StringBuilder();

        makeSingleBridge(upperRow, lowerRow);

        return upperRow + BridgeMapConstants.LINE_JUMPER.getValue() + lowerRow
                + BridgeMapConstants.LINE_JUMPER.getValue();
    }

    public boolean isGameSuccess() {
        return resultRecord.get(resultRecord.size() - 1);
    }

    public void updatePlayTime() {
        playTime++;
    }

    public void clear() {
        moveRecord.clear();
        resultRecord.clear();
    }

    private void makeSingleBridge(StringBuilder upperRow, StringBuilder lowerRow) {
        upperRow.append(BridgeMapConstants.STARTER.getValue());
        lowerRow.append(BridgeMapConstants.STARTER.getValue());

        for (int recordIndex = 0; recordIndex < moveRecord.size(); recordIndex++) {
            appendRecord(upperRow, lowerRow, recordIndex);
            appendSeparator(upperRow, lowerRow, recordIndex);
        }
    }

    private void appendSeparator(StringBuilder upperRow, StringBuilder lowerRow, int recordIndex) {
        String Separator = BridgeMapConstants.DIVIDER.getValue();
        if (recordIndex == moveRecord.size() - 1) {
            Separator = BridgeMapConstants.ENDER.getValue();
        }
        upperRow.append(Separator);
        lowerRow.append(Separator);
    }

    private void appendRecord(StringBuilder upperRow, StringBuilder lowerRow, int recordIndex) {
        for (GameCases gameCase : GAME_CASES) {
            if (moveRecord.get(recordIndex).equals(gameCase.getDirection())
                    && resultRecord.get(recordIndex) == gameCase.isResult()) {
                upperRow.append(gameCase.getUpperRowString());
                lowerRow.append(gameCase.getLowerRowString());
            }
        }
    }
}
