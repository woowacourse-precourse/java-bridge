package bridge.view;

import static bridge.constant.OutputMessage.*;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeToken;
import bridge.domain.Direction;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR = "[ERROR]";
    private static final String MOVABLE_SIGN = "O";
    private static final String IMMOVABLE_SIGN = "X";
    private static final String UNCHOSEN_SIGN = " ";
    private static final String BRIDGE_START_REGEX = "[ ";
    private static final String BRIDGE_END_REGEX = " ]\n";
    private static final String BRIDGE_SEPARATOR = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeToken> bridgeTokens) {
        System.out.println(createMap(bridgeTokens));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeGame.getBridgeTokens());

        System.out.println(printSuccessStatus(bridgeGame.isEnd()));

        System.out.println(TRY_COUNT_MESSAGE + bridgeGame.getRetryCount());
    }

    private String createMap(List<BridgeToken> bridgeTokens) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Direction direction : Direction.values()) {
            stringBuilder.append(bridgeTokens.stream()
                    .map(bridgeToken -> toSign(direction, bridgeToken))
                    .collect(Collectors.joining(BRIDGE_SEPARATOR, BRIDGE_START_REGEX, BRIDGE_END_REGEX)));
        }
        return String.valueOf(stringBuilder);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void printGameStartMessage() {
        System.out.println(BRIDGE_GAME_START_MESSAGE);
    }

    private String printSuccessStatus(boolean status) {
        if (status) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }

    private String toSign(Direction direction, BridgeToken bridgeToken) {
        if (direction.equals(bridgeToken.getDirection()) && bridgeToken.isCorrect()) {
            return MOVABLE_SIGN;
        } else if (direction.equals(bridgeToken.getDirection()) && !bridgeToken.isCorrect()) {
            return IMMOVABLE_SIGN;
        }

        return UNCHOSEN_SIGN;
    }
}
