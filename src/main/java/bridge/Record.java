package bridge;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<String> movingRecord ;
    private int retryCount ;
    Record() {
        this.movingRecord = new ArrayList<>();
        retryCount = 0;
    }
    Record(List<String> record) {
        this.movingRecord = new ArrayList<>(record);
    }
    public List<String> getRecord() {
        return this.movingRecord;
    }
    public int getRetryCount() {return retryCount;}
    public int getRecordLength(){
        return movingRecord.size();
    }
    public void add(String moving){
        movingRecord.add(moving);
    }
    public void show(List<String> bridge){
        OutputView.printMap(movingRecord,bridge );
    }

    public void printResult(List<String> bridge, boolean successFlag) {
        OutputView.printResult(this, bridge,successFlag);
    }
    public void reset(){
        movingRecord = new ArrayList<>();
    }
    public void addRetryCount() {
        this.retryCount = this.retryCount +1;
    }
}
