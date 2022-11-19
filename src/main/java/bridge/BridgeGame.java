package bridge;

import dto.BridgeGameDto;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다. BridgeGame의 패키지는 변경할 수 있다. BridgeGame 클래스에서 InputView,
 * OutputView 를 사용하지 않는다. BridgeGame의 메서드의 이름은 변경할 수 없다.
 */
public class BridgeGame {

    public static final List<String> candidate = Arrays.asList("U", "D", "R", "Q");
    private static int currentPosition = -1;
    private static int totalTrial = 1;
    private static String direction = null;
    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    public static final String QUIT = "Q";

    public void move(String direction) {
        checkValidity(direction);
        currentPosition++;
        BridgeGame.direction = direction;
    }

    private void checkValidity(String word) {
        if (!candidate.contains(word)) {
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
        checkValidity(command);
        if (command.equals(QUIT)) {
            Application.endGame(bridge, false);
            return;
        }
        totalTrial++;
        Application.totalResult = new Result();
        Application.launchGame(bridge);
    }
}
