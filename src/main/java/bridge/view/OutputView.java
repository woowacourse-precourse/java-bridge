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
        if (progress.isSuccess()) {
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
        if (progress.isSuccess()) {
            results.add(Result.SUCCESS);
            return;
        }
        results.add(Result.FAIL);
    }

    public void start() {
        System.out.println(Message.GAME_START + "\n");
    }

    public void enterBridgeSize() {
        System.out.println(Message.ENTER_BRIDGE_SIZE);
    }

    public void enterMove() {
        System.out.println(Message.ENTER_MOVE);
    }

    public void enterGameCommand() {
        System.out.println(Message.ENTER_GAME_COMMAND);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(Message.FINAL_GAME_RESULT);
        printMap(bridgeGame);
        printSuccess(bridgeGame);
        printTotalTry(bridgeGame);
    }

    public void printSuccess(BridgeGame bridgeGame) {
        System.out.println(Message.IS_GAME_SUCCESS + bridgeGame.showSuccess());
    }

    public void printTotalTry(BridgeGame bridgeGame){
        System.out.println(Message.TOTAL_TRY.toString() + bridgeGame.showTotalTry());
    }

    public void printError(Exception e){
        System.out.println(e.getMessage());
    }
}
