package bridge;

import bridge.enums.MarkResult;
import bridge.enums.Number;
import bridge.enums.Position;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<List<String>> results;
    int tryCount;
    String isSuccess;

    Result() {
        tryCount = 1;
        isSuccess = MarkResult.SUCCESS.getMessage();
        results = new ArrayList<>();
    }

    public void addResult(String movingPosition, boolean isCorrect) {
        if (isCorrect) {
            results.add(List.of(movingPosition, MarkResult.MARK_CORRECT.getMessage()));
        }

        if (!isCorrect) {
            results.add(List.of(movingPosition, MarkResult.MARK_INCORRECT.getMessage()));
        }
    }

    public void removeLastResult() {
        results.remove(results.size() - 1);
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setFail() {
        isSuccess = MarkResult.FAIL.getMessage();
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void makeUpPositionMap() {
        for (int i = Number.FIRST.getMessage(); i < results.size(); i++) {
            printMovableMark(String.valueOf(Position.UP.getMessage()), i);
            printNothing(String.valueOf(Position.DOWN.getMessage()), i);

            if (i == results.size() - 1) {
                continue;
            }
            System.out.print(" | ");
        }
    }

    public void makeDownPositionMap() {
        for (int i = Number.FIRST.getMessage(); i < results.size(); i++) {
            printMovableMark(String.valueOf(Position.DOWN.getMessage()), i);
            printNothing(String.valueOf(Position.UP.getMessage()), i);

            if (i == results.size() - 1) {
                continue;
            }
            System.out.print(" | ");
        }
    }

    public void printNothing(String position, int index) {
        if (results.get(index).get(Number.FIRST.getMessage()).equals(position)) {
            System.out.print(" ");
        }
    }

    public void printMovableMark(String position, int index) {
        if (results.get(index).get(Number.FIRST.getMessage()).equals(position)) {
            System.out.print(results.get(index).get(Number.SECOND.getMessage()));
        }
    }
}
