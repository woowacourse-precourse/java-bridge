package bridge.generator;

import bridge.game.Move;
import bridge.game.Result;
import bridge.generator.Answer;
import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    private final String START = "[";
    private final String DIVIDE = "|";
    private final String END = "]";
    private final String NEW_LINE = "\n";

    public String makeMap(List<Move> moves) {
        return getUpperBridgeMap(moves) + getLowerBridge(moves);
    }

    public String getUpperBridgeMap(List<Move> moves) {
        List<Result> upperBridgeResult = makeUpperBridgeResult(moves);
        String upperBridgeMap = changeResultsToString(upperBridgeResult);
        return START + upperBridgeMap + END + NEW_LINE;
    }

    public List<Result> makeUpperBridgeResult(List<Move> moves) {
        List<Result> result = new ArrayList<>();
        for (Move move : moves) {
            saveUpperMapResult(move, result);
        }
        return result;
    }

    public void saveUpperMapResult(Move move, List<Result> results) {
        if (move.getDestination().equals(Answer.DOWN.getLetter())) {
            results.add(Result.NONE);
            return;
        }
        if (move.isSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }

    public String changeResultsToString(List<Result> results) {
        String result = "";
        for (int i = 0; i < results.size() - 1; i++) {
            result += results.get(i) + DIVIDE;
        }
        return result + getLastResult(results);
    }

    public Result getLastResult(List<Result> results) {
        int lastIndex = results.size() - 1;
        return results.get(lastIndex);
    }

    public String getLowerBridge(List<Move> moves) {
        List<Result> lowerBridgeResult = makeLowerBridgeResult(moves);
        String lowerBridgeMap = changeResultsToString(lowerBridgeResult);
        return START + lowerBridgeMap + END + NEW_LINE;
    }

    public List<Result> makeLowerBridgeResult(List<Move> moves) {
        List<Result> result = new ArrayList<>();
        for (Move move : moves) {
            saveLowerMapResult(move, result);
        }
        return result;
    }

    public void saveLowerMapResult(Move move, List<Result> results) {
        if (move.getDestination().equals(Answer.UP.getLetter())) {
            results.add(Result.NONE);
            return;
        }
        if (move.isSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }
}
