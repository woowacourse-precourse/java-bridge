package bridge.view;

import bridge.game.BridgeGame;
import bridge.game.Progress;
import bridge.game.Result;
import bridge.generator.AreaStatus;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final String START = "[";
    private final String DIVIDE = "|";
    private final String END = "]";

    public void printMap(BridgeGame bridgeGame) {
        StringBuilder save = new StringBuilder();
        List<Progress> currentResult = bridgeGame.showCurrentResult();
        saveContent(makeResults(currentResult, AreaStatus.UP), save);
        saveContent(makeResults(currentResult, AreaStatus.DOWN), save);
        System.out.println(save);
    }

    public void saveContent(List<Result> results, StringBuilder map) {
        map.append(START);
        for (Result result : results) {
            map.append(result.toString() + DIVIDE);
        }
        int lastIndex = map.length() - 1;
        map.deleteCharAt(lastIndex);
        map.append(END + "\n");
    }

    public List<Result> makeResults(List<Progress> progresses, AreaStatus area) {
        List<Result> result = new ArrayList<>();
        for (Progress progress : progresses) {
            if (area.symbol.equals(AreaStatus.UP.symbol)) {
                saveUpperMapResult(progress, result);
            }
            if (area.symbol.equals(AreaStatus.DOWN.symbol)) {
                saveLowerMapResult(progress, result);
            }
        }
        return result;
    }

    public void saveUpperMapResult(Progress progress, List<Result> results) {
        if (progress.getDestination().equals(AreaStatus.DOWN.symbol)) {
            results.add(Result.NONE);
            return;
        }
        if (progress.getIsSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }

    public void saveLowerMapResult(Progress progress, List<Result> results) {
        if (progress.getDestination().equals(AreaStatus.UP.symbol)) {
            results.add(Result.NONE);
            return;
        }
        if (progress.getIsSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
