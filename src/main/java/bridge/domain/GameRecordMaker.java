package bridge.domain;

import bridge.constant.GameRecordFormat;

import java.util.ArrayList;
import java.util.List;

public class GameRecordMaker {
    private final List<List<String>> TOTAL_RESULT;
    private final int ZERO=0;
    private List<String> gameRecord;
    private int recordLength;

    public GameRecordMaker(){
        recordLength=ZERO;
        TOTAL_RESULT=List.of(new ArrayList<>(), new ArrayList<>());
    }
    private boolean isRecordLengthOverOne(){
        return recordLength==ZERO;
    }
    public void makeFormat(List<String> gameRecord){
        boolean isFirst = isRecordLengthOverOne();
        List<String> newRecord = new ArrayList<>();
        for(String record: gameRecord){
            GameRecordFormat gameRecordFormat = GameRecordFormat.findByTrial(isFirst);
            newRecord.add(gameRecordFormat.generate(record));
        }
        this.gameRecord=newRecord;
        ++recordLength;
    }

}
