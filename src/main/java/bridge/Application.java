package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> visited;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            init();
            gameStart();
            printGameResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void init() {
        outputView.printGameStart();
        String input = inputView.readBridgeSize();
        bridgeGame.init(input);
    }

    private static void gameStart() {
        while (true) {
            boolean keep = move();
            if (bridgeGame.isGameCompleted()) {
                break;
            }
            if (!keep && !retry()) {
                break;
            }
        }
    }

    private static boolean move() {
        String direction = inputView.readMoving();
        visited = bridgeGame.move(direction);
        printUpBridge();
        printDownBridge();

        return bridgeGame.isRightDirection(visited.size() - 1, direction);
    }

    private static void printDownBridge() {
        List<String> downString = new ArrayList<>();
        for (int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridgeGame.isRightDirection(i, visited.get(i));
            String result = bridgeGame.getResult(i, "D", rightDirection);
            downString.add(result);
        }
        outputView.printMap(downString);
    }

    private static void printUpBridge() {
        List<String> upString = new ArrayList<>();
        for (int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridgeGame.isRightDirection(i, visited.get(i));
            String result = bridgeGame.getResult(i, "U", rightDirection);
            upString.add(result);
        }
        outputView.printMap(upString);
    }

    public String getResult(int i, String direction, boolean rightDirection) {
        String result = "O";
        if (!rightDirection) {
            result = "X";
        }
        if (!visited.get(i).equals(direction)) {
            result = " ";
        }
        return result;
    }

    private static boolean retry() {
        String select = inputView.readGameCommand();
        return bridgeGame.retry(select);
    }

    private static void printGameResult() {
        outputView.printEnding();
        printUpBridge();
        printDownBridge();
        String result = bridgeGame.getGameResult();
        int tryNum = bridgeGame.getTryNum();
        outputView.printResult(result, tryNum);
    }

}
