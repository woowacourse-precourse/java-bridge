package bridge.generator;

import bridge.game.Move;
import bridge.game.Result;
import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    public String makeMap(List<Move> moves) {
        return getUpperBridgeMap(moves) + getLowerBridge(moves);
    }

    public String getUpperBridgeMap(List<Move> moves) {
        List<Result> upperBridgeResult = makeUpperBridgeResult(moves);
        String upperBridgeMap = changeResultsToString(upperBridgeResult);
        return MapFormat.START + upperBridgeMap + MapFormat.END + MapFormat.NEW_LINE;
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
        StringBuilder printableResult = new StringBuilder();
        for (int index = 0; index < results.size(); index++) {
            printableResult.append(results.get(index));
            printableResult.append(MapFormat.DIVIDE);
        }
        int removeDivideIndex = printableResult.length() - 1;
        printableResult.deleteCharAt(removeDivideIndex);
        return printableResult.toString();
    }

    public Result getLastResult(List<Result> results) {
        int lastIndex = results.size() - 1;
        return results.get(lastIndex);
    }

    public String getLowerBridge(List<Move> moves) {
        List<Result> lowerBridgeResult = makeLowerBridgeResult(moves);
        String lowerBridgeMap = changeResultsToString(lowerBridgeResult);
        return MapFormat.START + lowerBridgeMap + MapFormat.END + MapFormat.NEW_LINE;
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
