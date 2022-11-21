package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(bridgeGame.getBridgeGameUpResult() + "]");
        System.out.println(bridgeGame.getBridgeGameDownResult()+ "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int gameTryCount) {
        System.out.println("\n최종 게임 결과");
        printMap();

        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }
}
