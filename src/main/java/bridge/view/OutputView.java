package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeToken;
import bridge.domain.Direction;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeToken> bridgeTokens) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Direction direction : Direction.values()) {
            stringBuilder.append("[ ");
            stringBuilder.append(bridgeTokens.stream()
                    .map(bridgeToken -> toSign(direction, bridgeToken))
                    .collect(Collectors.joining(" | ")));
            stringBuilder.append(" ]\n");
        }
        System.out.println(stringBuilder);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridgeTokens());
        extracted(bridgeGame.isEnd());
        System.out.println("총 시도한 횟수: " + bridgeGame.getRetryCount());
    }

    private static void extracted(boolean status) {
        if (status) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
    }

    public void printGameStartMessage() {
        System.out.println(BRIDGE_GAME_START_MESSAGE);
    }

    private String toSign(Direction direction, BridgeToken bridgeToken) {
        if (direction.equals(bridgeToken.getDirection()) && bridgeToken.isCorrect()) {
            return "O";
        } else if (direction.equals(bridgeToken.getDirection()) && !bridgeToken.isCorrect()) {
            return "X";
        }
        return " ";
    }
}
