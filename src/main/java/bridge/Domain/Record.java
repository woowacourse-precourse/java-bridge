package bridge.Domain;

import bridge.View.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<String> movingRecord ;
    private int retryCount ;

    public Record() {
        this.movingRecord = new ArrayList<>();
        retryCount = 1;
    }

    public List<String> getRecord() {
        return this.movingRecord;
    }
    public int getRetryCount() {return retryCount;}
    public int getRecordLength(){
        return movingRecord.size();
    }

    public void addMoving(String moving){
        movingRecord.add(moving);
    }
    public void addRetryCount() {
        this.retryCount = this.retryCount +1;
    }

    public void printMap(List<String> bridge){
        OutputView.printMap(movingRecord,bridge);
    }
    public void printResult(List<String> bridge, boolean successFlag) {
        OutputView.printResult(this, bridge,successFlag);
    }
    public void reset(){
        movingRecord = new ArrayList<>();
    }
}
