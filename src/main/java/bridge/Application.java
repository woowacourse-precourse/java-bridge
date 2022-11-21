package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.Constant.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
        moveUser(makeBridge());
    }

    public static void gameStart() {
        outputView.printGameStartPhrase();
    }

    public static List<String> makeBridge() {
        outputView.printBridgeLengthInputPhrase();
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public static void moveUser(List<String> bridge) {
        int count = 1;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            outputView.printMovingBlockInputPhrase();
            String moving = inputView.readMoving();
            boolean moveResult = bridgeGame.move(moving, bridge.get(i));
            if (moveResult) {
                outputView.printMap(addTrueResult(i, moving, result));
            }
            if (!moveResult) {
                outputView.printMap(addFalseResult(i, moving, result));
                outputView.printRestartMessage();
                if (inputView.readGameCommand().equals("Q")) {
                    endGame(result);
                    break;
                }
                result = new ArrayList<>();
                count++;
                i = -1;
            }
        }
        System.out.println("총 시도한 횟수: " + count);
    }

    public static void endGame(List<String> result) {
        outputView.printResult(result);
    }

    public static void mR(boolean rst) {

    }

    public static List<String> addTrueResult(int count, String moving, List<String> result) {
        if (count == 0) {
            addTrueResultCountZero(moving, result);
        }
        if (count != 0) {
            addTrueResultCountNoZero(count, moving, result);
        }
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
        }
        if (count != 0) {
            addFalseResultCountNoZero(count, moving, result);
        }
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






















