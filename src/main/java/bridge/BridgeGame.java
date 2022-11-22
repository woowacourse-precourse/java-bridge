package bridge;

import bridge.dto.BridgeGameDto;
import java.util.Arrays;
import java.util.List;
import bridge.view.InputView;
import java.util.Objects;

public class BridgeGame {
    private static int currentPosition = -1;
    private static int totalTrial = 1;
    private static Direction direction;
    public static boolean valueError = false;
    private final List<String> moveCandidate = Arrays.asList("U", "D");
    private final List<String> decisionCandidate = Arrays.asList("R", "Q");
    private final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    private final String QUIT = "Q";
    private static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    public void move(String input) {
        valueError = false;
        Direction direction;
        try {
            this.direction = Direction.of(input);
        } catch (IllegalArgumentException e) {
            valueError = true;
            if (!InputView.sizeFormatError) {
                System.out.println(e.getMessage());
            }
        }
        if (!valueError) {
            currentPosition++;
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

    private void checkCommandValidity(String word) {
        if (!decisionCandidate.contains(word)) {
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
    public void initializeValues() {
        currentPosition = -1;
        direction = null;
    }

    public BridgeGameDto sendDto() {
        return new BridgeGameDto(currentPosition, totalTrial, direction);
    }
}
