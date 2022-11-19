package bridge;

import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.domain.MovingCommand;
import java.util.ArrayList;
import java.util.List;

public class OutputView extends View {

    private static final String LETS_START = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS = "게임 성공 여부: %s";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: %d";

    public void printMap(BridgeStatus bridgeStatus) {
        List<String> userBridge = bridgeStatus.getUserBridge();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        for (String command : userBridge) {
            if (command.equals(MovingCommand.UP.toString())) {
                first.add("O");
                second.add(" ");
            }
            if (command.equals(MovingCommand.DOWN.toString())) {
                first.add(" ");
                second.add("O");
            }
        }
        GameStatus gameStatus = bridgeStatus.getGameStatus();
        if (gameStatus.equals(GameStatus.FAIL)) {
            int lastIndex = first.size() - 1;
            first.remove(lastIndex);
            second.remove(lastIndex);
            if (userBridge.get(lastIndex).equals(MovingCommand.UP.toString())) {
                first.add(" ");
                second.add("X");
            }
            if (userBridge.get(lastIndex).equals(MovingCommand.DOWN.toString())) {
                first.add("X");
                second.add(" ");
            }
        }
        String firstLine = first.toString()
                .replaceAll(", ", " | ")
                .replaceAll("\\[", "[ ")
                .replaceAll("]", " ]");
        String secondLine = second.toString()
                .replaceAll(", ", " | ")
                .replaceAll("\\[", "[ ")
                .replaceAll("]", " ]");
        print(firstLine + "\n" + secondLine);
    }

    public void printResult(BridgeStatus bridgeStatus) {
        print(FINAL_RESULT);
        printMap(bridgeStatus);
        printEmptyLine();
        print(String.format(GAME_STATUS, bridgeStatus.getGameStatus().getDetails()));
        print(String.format(TOTAL_TRY_COUNT, bridgeStatus.getTryCount()));
    }

    public void printEmptyLine() {
        print();
    }

    public void printStart() {
        print(LETS_START);
    }
}
