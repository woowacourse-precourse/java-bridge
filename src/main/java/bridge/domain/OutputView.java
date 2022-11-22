package bridge.domain;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(bridgeGame.getBridge().toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        Bridge bridge = bridgeGame.getBridge();
        StringBuilder sb = new StringBuilder("최종 게임 결과\n").append(bridge.toString()).append("\n\n게임 성공 여부: ");
        if (bridge.getBridgeGameState() == BridgeGameState.SUCCESS_AND_END) { sb.append("성공\n"); }
        if (bridge.getBridgeGameState() == BridgeGameState.FAIL) { sb.append("실패\n"); }
        sb.append("총 시도한 횟수: ").append(bridgeGame.getNumOfGamePlayed());
        System.out.println(sb.toString());
    }
}
