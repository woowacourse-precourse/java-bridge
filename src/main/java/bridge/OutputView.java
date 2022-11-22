package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final BridgeGame bridgeGame;
    private final String LEFT_CONTAINER = "[ ";
    private final String RIGHT_CONTAINER = " ]";
    private final String ABOUT_RESULT = "최종 게임 결과";
    private final String ABOUT_GAME_STATE = "게임 성공 여부: ";
    private final String ABOUT_PLAYED_COUNT = "총 시도한 횟수: ";



    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // 그대로인지, 재시도인지, 종료인지에 대한 파라미터 입력
    public void printMap(String inputMoving) {
        List<StringBuilder> nowMap = bridgeGame.getMap(inputMoving);
        // 그대로일 때 출력
        for (int i = 0; i < 2; i++) {
            System.out.println(LEFT_CONTAINER + nowMap.get(i) + RIGHT_CONTAINER);
        }
    }

    public void printMapWhenFailed(String inputMoving) {
        List<StringBuilder> nowMapWhenFailed = bridgeGame.getMapWhenFailed(inputMoving);
        for (int i = 0; i < 2; i++) {
            System.out.println(LEFT_CONTAINER + nowMapWhenFailed.get(i) + RIGHT_CONTAINER);
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(ABOUT_RESULT);
        System.out.println(LEFT_CONTAINER + bridgeGame.FIRST_LINE_DATA + RIGHT_CONTAINER);
        System.out.println(LEFT_CONTAINER + bridgeGame.SECOND_LINE_DATA + RIGHT_CONTAINER);
        System.out.println(ABOUT_GAME_STATE + bridgeGame.GAME_STATE);
        System.out.println(ABOUT_PLAYED_COUNT + bridgeGame.playedCount);
    }
}
