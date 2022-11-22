package bridge.domain.model;

import static bridge.domain.enums.Move.*;
import static bridge.domain.enums.Result.NOTHING;

import bridge.domain.enums.Move;
import bridge.domain.enums.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreMap {

    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String DELIMITER = " | ";

    private List<String> upperBoard = new ArrayList<>();
    private List<String> underBoard = new ArrayList<>();

    public void score(Result judgeResult, Move direction) {
        if (direction.equals(U)) {
            addUp(judgeResult.getSymbol());
        }
        if (direction.equals(D)) {
            addDown(judgeResult.getSymbol());
        }
    }

    private void addDown(String judgeResult) {
        underBoard.add(judgeResult);
        upperBoard.add(NOTHING.getSymbol());
    }

    private void addUp(String judgeResult) {
        upperBoard.add(judgeResult);
        underBoard.add(NOTHING.getSymbol());
    }


    @Override
    public String toString() {
        return upperBoard.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)) + "\n"
                + underBoard.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)) + "\n";
    }

    public void clear() {
        upperBoard.clear();
        underBoard.clear();
    }

}
