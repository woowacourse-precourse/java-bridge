package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.Constant.*;

public class Application {
    static int tryCount = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
        System.out.println("총 시도한 횟수: " + moveUser(makeBridge()));
    }

    public static void gameStart() {
        OUTPUT_VIEW.printGameStartPhrase();
    }

    public static List<String> makeBridge() {
        OUTPUT_VIEW.printBridgeLengthInputPhrase();
        return BRIDGE_MAKER.makeBridge(INPUT_VIEW.readBridgeSize());
    }

    public static int moveUser(List<String> bridge) {
        List<String> result = new ArrayList<>();
        List<String> moveResult = moveDetail(result, bridge);
        if (!moveResult.isEmpty()) {
            OUTPUT_VIEW.printClearResult(moveResult);
        }
        return tryCount;
    }

    public static List<String> moveDetail(List<String> result, List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            String moving = inputUpDown();
            if (!BRIDGE_GAME.move(moving, bridge.get(i))) {
                OUTPUT_VIEW.printMap(addFalseResult(i, moving, result));
                i = restartGame(result, bridge);
                result.clear();
                continue;
            }
            OUTPUT_VIEW.printMap(addTrueResult(i, moving, result));
        }
        return result;
    }

    public static String inputUpDown() {
        OUTPUT_VIEW.printMovingBlockInputPhrase();
        return INPUT_VIEW.readMoving();
    }

    public static int restartGame(List<String> result, List<String> bridge) {
        OUTPUT_VIEW.printRestartMessage();
        return restartGameDetail(INPUT_VIEW.readGameCommand(), result, bridge);
    }

    public static int restartGameDetail(String readGameCommand, List<String> result, List<String> bridge) {
        if (readGameCommand.equals("R")) {
            tryCount++;
            return -1;
        }
        if (readGameCommand.equals("Q")) {
            endGame(result);
        }
        return bridge.size();
    }

    public static void endGame(List<String> result) {
        OUTPUT_VIEW.printFailResult(result);
    }

    public static List<String> addTrueResult(int count, String moving, List<String> result) {
        if (count == 0) {
            addTrueResultCountZero(moving, result);
            return result;
        }
        addTrueResultCountNoZero(count, moving, result);
        return result;
    }

    public static void addTrueResultCountZero(String moving, List<String> result) {
        if (moving.equals("U")) {
            result.add("[ O ]");
            result.add("[   ]");
        }
        if (moving.equals("D")) {
            result.add("[   ]");
            result.add("[ O ]");
        }
    }

    public static void addTrueResultCountNoZero(int count, String moving, List<String> result) {
        if (moving.equals("U")) {
            result.set(0, result.get(0).substring(0, count * 4) + "| O ]");
            result.set(1, result.get(1).substring(0, count * 4) + "|   ]");
        }
        if (moving.equals("D")) {
            result.set(0, result.get(0).substring(0, count * 4) + "|   ]");
            result.set(1, result.get(1).substring(0, count * 4) + "| O ]");
        }
    }

    public static List<String> addFalseResult(int count, String moving, List<String> result) {
        if (count == 0) {
            addFalseResultCountZero(moving, result);
            return result;
        }
        addFalseResultCountNoZero(count, moving, result);
        return result;
    }

    public static void addFalseResultCountZero(String moving, List<String> result) {
        if (moving.equals("U")) {
            result.add("[ X ]");
            result.add("[   ]");
        }
        if (moving.equals("D")) {
            result.add("[   ]");
            result.add("[ X ]");
        }
    }

    public static void addFalseResultCountNoZero(int count, String moving, List<String> result) {
        if (moving.equals("U")) {
            result.set(0, result.get(0).substring(0, count * 4) + "| X ]");
            result.set(1, result.get(1).substring(0, count * 4) + "|   ]");
        }
        if (moving.equals("D")) {
            result.set(0, result.get(0).substring(0, count * 4) + "|   ]");
            result.set(1, result.get(1).substring(0, count * 4) + "| X ]");
        }
    }
}






















