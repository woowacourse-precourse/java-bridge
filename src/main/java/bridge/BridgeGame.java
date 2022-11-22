package bridge;

import dto.BridgeGameDto;
import java.util.Arrays;
import java.util.List;
import view.InputView;

public class BridgeGame {
    private int currentPosition = -1;
    private static int totalTrial = 1;
    private static String direction = null;
    public static final List<String> moveCandidate = Arrays.asList("U", "D");

    public static final List<String> decisionCandidate = Arrays.asList("R", "Q");
    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    public static final String QUIT = "Q";

    public static boolean valueError = false;

    public void move(String direction) {
        valueError = false;
        dealMoveError(direction);
        if (!valueError) {
            currentPosition++;
            BridgeGame.direction = direction;
        }
    }

    public void dealMoveError(String direction) {
        try {
            checkMoveValidity(direction);
        } catch (IllegalArgumentException e) {
            if (!InputView.sizeFormatError) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkMoveValidity(String word) {
        if (!moveCandidate.contains(word)) {
            valueError = true;
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    public void makeRetryDecision(Bridge bridge, String command) {
        if (command.equals(QUIT)) {
            Application.endGame(bridge, false);
            return;
        }
        totalTrial++;
        Application.totalResult = new Result();
        Application.launchGame(bridge);
    }

    private void checkCommandValidity(String word) {
        if (!decisionCandidate.contains(word)) {
            valueError = true;
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    public void retry(Bridge bridge, String command) {
        try {
            checkCommandValidity(command);
        } catch (IllegalArgumentException e) {
            if (!InputView.commandFormatError) {
                System.out.println(e.getMessage());
            }
            return;
        }
        makeRetryDecision(bridge, command);
    }

    public void initializeValues() {
        currentPosition = -1;
        direction = null;
    }

    public BridgeGameDto sendDto() {
        return new BridgeGameDto(currentPosition, totalTrial, direction);
    }
}
