package bridge.domain;

import bridge.constant.GameRecordFormat;
import bridge.constant.GameRecordSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameRecordMaker {
    private final List<List<String>> TOTAL_RESULT;
    private final int ZERO=0;
    private final int RESULT_SIZE=2;

    private List<String> currentGameRecord;
    private int recordLength;

    public GameRecordMaker(){
        recordLength=ZERO;
        TOTAL_RESULT=List.of(new ArrayList<>(), new ArrayList<>());
    }
    private boolean isRecordLengthOverOne(){
        return recordLength==ZERO;
    }

    public String makeFormat(boolean isFirst, String record){
        GameRecordFormat gameRecordFormat = GameRecordFormat.findByTrial(isFirst);
        return gameRecordFormat.generate(record);
    }

    public List<String> transformCurrentRecord(boolean isFirst, List<String> gameRecord){
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
        ++recordLength;
    }

    public void updateResult(){
        for(int i=ZERO; i<RESULT_SIZE;i++){
            List<String> result= TOTAL_RESULT.get(i);
            result.add(currentGameRecord.get(i));
        }
    }

}
