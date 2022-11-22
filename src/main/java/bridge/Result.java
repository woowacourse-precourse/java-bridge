package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<List<String>> results;
    int tryCount;
    String isSuccess;

    Result() {
        tryCount = 1;
        isSuccess = "성공";
        results = new ArrayList<>();
    }

    public void addResult(String movingPosition, boolean isCorrect) {
        if (isCorrect) {
            results.add(List.of(movingPosition, "O"));
        }

        if (!isCorrect) {
            results.add(List.of(movingPosition, "X"));
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
        isSuccess = "실패";
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void makeUpPositionMap() {
        for (int i = 0; i < results.size(); i++) {
            printMovableMark("U", i);
            printNothing("D", i);

            if (i == results.size() - 1) {
                continue;
            }
            System.out.print(" | ");
        }
    }

    public void makeDownPositionMap() {
        for (int i = 0; i < results.size(); i++) {
            printMovableMark("D", i);
            printNothing("U", i);

            if (i == results.size() - 1) {
                continue;
            }
            System.out.print(" | ");
        }
    }

    public void printNothing(String position, int index) {
        if (results.get(index).get(0).equals(position)) {
            System.out.print(" ");
        }
    }

    public void printMovableMark(String position, int index) {
        if (results.get(index).get(0).equals(position)) {
            System.out.print(results.get(index).get(1));
        }
    }
}
