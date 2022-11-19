package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeGame bridgeGame = new BridgeGame();
    String bridgeGameUpResult = "[";
    String bridgeGameDownResult = "[";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean isMoving, String moving) {
        String movingResult = "";

        if (!bridgeGameUpResult.equals("[")) {
            bridgeGameUpResult += "|";
            bridgeGameDownResult += "|";
        }

        if (isMoving) {
            movingResult = " O ";
        } else {
            movingResult = " X ";
        }

        if (moving.equals("U")) {
            bridgeGameUpResult += movingResult;
            bridgeGameDownResult += "   ";
        } else {
            bridgeGameUpResult += "   ";
            bridgeGameDownResult += movingResult;
        }

        System.out.println(bridgeGameUpResult+"]");
        System.out.println(bridgeGameDownResult+"]");

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
