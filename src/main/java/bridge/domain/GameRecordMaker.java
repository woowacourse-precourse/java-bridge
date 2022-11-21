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
        System.out.println(recordLength);

    }

    public void updateResult(){
        for(int i=ZERO; i<RESULT_SIZE;i++){
            List<String> result= TOTAL_RESULT.get(i);
            result.add(currentGameRecord.get(i));
        }
        recordLength+=1;
    }

    public String makeMapFormat(List<String> result){
        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append(GameRecordSymbol.START_BRACKET.getSymbol());
        formattedResult.append(String.join(GameRecordSymbol.BLANK.getSymbol(), result));
        formattedResult.append(GameRecordSymbol.END_BRACKET.getSymbol());
        formattedResult.append(GameRecordSymbol.NEW_LINE.getSymbol());
        return formattedResult.toString();
    }

}
