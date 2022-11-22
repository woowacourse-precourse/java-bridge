package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGame {

    private static String isSuccess = "성공";
    private static int tryCount = 1;
    private static String isRetry;
    public static List<String> move(String input, String availBridge) {
        String result = "X";
        if (Objects.equals(input, availBridge))
            result = "O";
        return currentPlaying(input, result);
    }

    public static List<String> currentPlaying(String move, String result) {
        List<String> currentPlaying = new ArrayList<>();
        currentPlaying.add(move);
        currentPlaying.add(result);
        return currentPlaying;
    }

    public static void gameProcess(List<String> bridge) {
        List<List<String>> userPlaying = gameLoop(bridge);
        gameOver(userPlaying, bridge);
    }

    public static List<List<String>> gameLoop(List<String> bridge) {
        List<List<String>> userPlaying = new ArrayList<>();
        for (String s : bridge) {
            List<String> currentPlaying = move(Application.inputMove(), s);
            userPlaying.add(currentPlaying);
            Application.printMap(userPlaying);
            if (currentPlaying.contains("X")) {
                isRetry = Application.inputGameCommand();
                isSuccess = "실패";
                break;
            }
        }
        return userPlaying;
    }

    public static void gameOver(List<List<String>> userPlaying, List<String> bridge) {
        if (Objects.equals(isRetry, "R")) {
            isRetry = "";
            retry(bridge);
            return;
        }
        Application.printResult(isSuccess, tryCount, userPlaying);
    }

    public static void retry(List<String> bridge) {
        tryCount++;
        isSuccess = "성공";
        gameProcess(bridge);
    }
}
