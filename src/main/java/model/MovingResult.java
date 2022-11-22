package model;

import java.util.ArrayList;
import java.util.List;

public class MovingResult {

    private List<String> upResult;

    private List<String> downResult;

    public MovingResult() {
        upResult = new ArrayList<>();
        downResult = new ArrayList<>();
    }

    public void clearResult() {
        upResult.clear();
        downResult.clear();
    }

    public void addUpResult(String moving) {
        upResult.add(moving);
    }

    public void addDownResult(String moving) {
        downResult.add(moving);
    }
    public int sizeUpResult(){
        return upResult.size();
    }
    public String upResultAt(int location){
        return upResult.get(location);
    }

    public String downResultAt(int location){
        return downResult.get(location);
    }
    public int sizeDownResult(){
        return downResult.size();
    }

}
