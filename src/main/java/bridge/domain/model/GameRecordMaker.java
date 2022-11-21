package bridge.domain.model;

import bridge.domain.constant.GameRecordFormat;
import bridge.domain.constant.GameRecordSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameRecordMaker {
    private final List<List<String>> TOTAL_RESULT;
    private final int ZERO=0;

    private List<String> currentGameRecord;
    private int recordLength;

    public GameRecordMaker(){
        recordLength=ZERO;
        TOTAL_RESULT=List.of(new ArrayList<>(), new ArrayList<>());
    }
    private boolean isRecordLengthOverOne(){
        return recordLength==ZERO;
    }

    private String makeFormat(boolean isFirst, String record){
        GameRecordFormat gameRecordFormat = GameRecordFormat.findByTrial(isFirst);
        return gameRecordFormat.generate(record);
    }

    private List<String> transformCurrentRecord(boolean isFirst, List<String> gameRecord){
        List<String> transformedRecord = new ArrayList<>();
        for(String record: gameRecord){
            String formattedRecord = makeFormat(isFirst, record);
            transformedRecord.add(formattedRecord);
        }
        return transformedRecord;
    }

    public void updateCurrentRecord(List<String> gameRecord){
        boolean isFirst = isRecordLengthOverOne();
        currentGameRecord=transformCurrentRecord(isFirst, gameRecord);
    }

    public void updateResult(){
        ListIterator<List<String>> totalResult =TOTAL_RESULT.listIterator();
        while(totalResult.hasNext()){
            int currentIndex = totalResult.nextIndex();
            List<String> result = totalResult.next();
            result.add(currentGameRecord.get(currentIndex));
        }
        ++recordLength;
    }

    public String makeMapFormat(List<String> result){
        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append(GameRecordSymbol.START_BRACKET.getSymbol());
        formattedResult.append(String.join(GameRecordSymbol.BLANK.getSymbol(), result));
        formattedResult.append(GameRecordSymbol.END_BRACKET.getSymbol());
        formattedResult.append(GameRecordSymbol.NEW_LINE.getSymbol());
        return formattedResult.toString();
    }

    public String getRecord() {
        StringBuilder record = new StringBuilder();
        for(List<String> result: TOTAL_RESULT){
            record.append(makeMapFormat(result));
        }
        return record.toString();
    }

}
