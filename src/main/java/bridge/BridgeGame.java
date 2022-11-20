package bridge;

import dto.BridgeGameDto;
import java.util.Arrays;
import java.util.List;

public class BridgeGame {
    private static int currentPosition = -1;
    private static int totalTrial = 1;
    private static String direction = null;
    public static final List<String> moveCandidate = Arrays.asList("U", "D");

    public static final List<String> decisionCandidate = Arrays.asList("R", "Q");
    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    public static final String QUIT = "Q";


    public void move(String direction) {
        checkMoveValidity(direction);
        currentPosition++;
        BridgeGame.direction = direction;
    }

    private void checkMoveValidity(String word) {
        if (!moveCandidate.contains(word)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    public BridgeGameDto sendDto() {
        return new BridgeGameDto(currentPosition, totalTrial, direction);
    }

    public void initializeValues() {
        currentPosition = -1;
        direction = null;
    }

    public void retry(Bridge bridge, String command) {
        checkDecisionValidity(command);
        if (command.equals(QUIT)) {
            Application.endGame(bridge, false);
            return;
        }
        totalTrial++;
        Application.totalResult = new Result();
        Application.launchGame(bridge);
    }

    private void checkDecisionValidity(String word) {
        if (!decisionCandidate.contains(word)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }
}
