package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<List<String>> map;
    private boolean isSuccess;
    private int tryCount;

    public Result(){
        map = new ArrayList<>();

        for(int i = 0;i<2;i++){
            map.add(new ArrayList<>());
        }

        isSuccess = false;
        tryCount = 1;
    }

    public void makeMap(List<String> spaces, List<String> moves){

    }

    public void addTryCount(){
        tryCount++;
    }

    public List<List<String>> getMap() {
        return map;
    }

    public void setMap(List<List<String>> map) {
        this.map = map;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
