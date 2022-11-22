package bridge.domain.model;

import bridge.domain.constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameRecordMaker {
    private List<List<String>> TOTAL_RESULT;

    public GameRecordMaker() {
        TOTAL_RESULT = List.of(new ArrayList<>(), new ArrayList<>());
    }

    public void updateResult(List<String> currentGameRecord) {
        ListIterator<List<String>> totalResult = TOTAL_RESULT.listIterator();

        while (totalResult.hasNext()) {
            int currentIndex = totalResult.nextIndex();
            List<String> result = totalResult.next();
            result.add(currentGameRecord.get(currentIndex));
        }
    }

    public String makeMapFormat(List<String> result) {
        String formattedResult = GameRecordSymbol.START_BRACKET.getSymbol() +
                String.join(GameRecordSymbol.BLANK.getSymbol(), result) +
                GameRecordSymbol.END_BRACKET.getSymbol() +
                GameRecordSymbol.NEW_LINE.getSymbol();
        return formattedResult;
    }

    public void reset(){
        TOTAL_RESULT = List.of(new ArrayList<>(), new ArrayList<>());
    }

    public String getRecord() {
        StringBuilder record = new StringBuilder();
        for (List<String> result : TOTAL_RESULT) {
            record.append(makeMapFormat(result));
        }
        return record.toString();
    }

}
