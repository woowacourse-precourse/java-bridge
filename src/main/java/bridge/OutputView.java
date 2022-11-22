package bridge;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private BridgeGame bridgeGame = new BridgeGame();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(bridgeGame.getMap().toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber, String successFail) {
        System.out.println(Constant.FINAL_RESULT_MESSAGE);
        System.out.println(bridgeGame.getMap().toString());
        System.out.println(Constant.GAME_WIN_MESSAGE + successFail + Constant.NEXT
                + Constant.OVERALL_TRY_NUMBER + tryNumber);
    }
}
