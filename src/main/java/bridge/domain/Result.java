package bridge.domain;

import bridge.util.InputConstant;
import bridge.util.OutputConstant;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final int EMPTY = 0;
    private final List<String> upStairs;
    private final List<String> downsStairs;

    public Result() {
        this.upStairs = new ArrayList<>();
        this.downsStairs = new ArrayList<>();
    }

    public void addUpstairs() {
        upStairs.add(OutputConstant.PASS_POSSIBLE.getValue());
        downsStairs.add(OutputConstant.EMPTY.getValue());
    }

    public void addDownsStairs() {
        upStairs.add(OutputConstant.EMPTY.getValue());
        downsStairs.add(OutputConstant.PASS_POSSIBLE.getValue());
    }

    public void recordDirection(String direction) {
        if(direction.equals(InputConstant.UP.getValue())) {
            addUpstairs();
        }
        if(direction.equals(InputConstant.DOWN.getValue())) {
            addDownsStairs();
        }
    }

    public String makeUpStairsMessage() {
        if(upStairs.size() == EMPTY) {
            return "";
        }
        return upStairs.toString().replaceAll(OutputConstant.COMMA.getValue(), OutputConstant.BAR.getValue());
    }

    public String makeDownStairsMessage() {
        if(downsStairs.size() == EMPTY) {
            return "";
        }
        return downsStairs.toString().replaceAll(OutputConstant.COMMA.getValue(), OutputConstant.BAR.getValue());
    }

    public void changeUpStairsRecord() {
        upStairs.set(upStairs.size() - 1, OutputConstant.PASS_IMPOSSIBLE.getValue());
    }

    public void changeDownStairsRecord() {
        downsStairs.set(downsStairs.size() - 1, OutputConstant.PASS_IMPOSSIBLE.getValue());
    }
}
