package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {

    }

    public void printBridgeSizeGuide() {

    }

    public void printMovingGuide() {

    }

    public void printGameCommandGuide() {

    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param trial
     * @param bridge
     * @param userRoute
     */
    public void printResult(int trial, List<String> bridge, List<String> userRoute) {
    }
}
