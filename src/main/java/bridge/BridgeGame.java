package bridge;

import dto.BridgeGameDto;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다. BridgeGame의 패키지는 변경할 수 있다. BridgeGame 클래스에서 InputView,
 * OutputView 를 사용하지 않는다. BridgeGame의 메서드의 이름은 변경할 수 없다.
 */
public class BridgeGame {

    public static final List<String> UP = Arrays.asList("U", "u");
    public static final List<String> DOWN = Arrays.asList("D", "d");
    private static int currentPosition = -1;
    private static int totalTrial = 0;
    private static String direction = null;

    public void move(String direction) {
        checkDirectionValidity(direction);
        currentPosition++;
        totalTrial++;
        BridgeGame.direction = direction;
    }

    private void checkDirectionValidity(String direction) {
        if (!UP.contains(direction)
                && !DOWN.contains(direction)) {
            throw new IllegalArgumentException("[ERROR] 유효한 방향은 U 또는 D 입니다.");
        }
    }

    public BridgeGameDto sendDto() {
        return new BridgeGameDto(currentPosition, totalTrial, direction);
    }

    public void initializeValues() {
        currentPosition = -1;
        direction = null;
    }

    public void retry() {
    }
}
