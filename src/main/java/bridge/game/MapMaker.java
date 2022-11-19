package bridge.game;

import bridge.generator.AreaStatus;
import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    private final String START = "[";
    private final String DIVIDE = "|";
    private final String END = "]";
    private final String NEW_LINE = "\n";

    public String makeMap(List<Progress> progresses) {
        StringBuilder map = new StringBuilder();
        map.append(getUpperBridgeMap(progresses));
        map.append(getLowerBridge(progresses));
        return map.toString();
    }

    public String getUpperBridgeMap(List<Progress> progresses) {
        List<Result> upperBridgeResult = makeUpperBridgeResult(progresses);
        String upperBridgeMap = changeResultToString(upperBridgeResult);
        return START + upperBridgeMap + END + NEW_LINE;
    }

    public List<Result> makeUpperBridgeResult(List<Progress> progresses) {
        List<Result> result = new ArrayList<>();
        for (Progress progress : progresses) {
            saveUpperMapResult(progress, result);
        }
        return result;
    }

    public void saveUpperMapResult(Progress progress, List<Result> results) {
        if (progress.getDestination().equals(AreaStatus.DOWN.symbol)) {
            results.add(Result.NONE);
            return;
        }
        if (progress.isSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }

    public String changeResultToString(List<Result> results) {
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

    public String getLowerBridge(List<Progress> progresses) {
        List<Result> lowerBridgeResult = makeLowerBridgeResult(progresses);
        String lowerBridgeMap = changeResultToString(lowerBridgeResult);
        return START + lowerBridgeMap + END + NEW_LINE;
    }

    public List<Result> makeLowerBridgeResult(List<Progress> progresses) {
        List<Result> result = new ArrayList<>();
        for (Progress progress : progresses) {
            saveLowerMapResult(progress, result);
        }
        return result;
    }

    public void saveLowerMapResult(Progress progress, List<Result> results) {
        if (progress.getDestination().equals(AreaStatus.UP.symbol)) {
            results.add(Result.NONE);
            return;
        }
        if (progress.isSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }
}
