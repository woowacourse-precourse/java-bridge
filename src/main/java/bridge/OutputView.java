package bridge;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    // 그대로인지, 재시도인지, 종료인지에 대한 파라미터 입력
    public void printMap(String inputMoving) {
        List<StringBuilder> nowMap = bridgeGame.getMap(inputMoving);
        // 그대로일 때 출력
        for (int i = 0; i < 2; i++) {
            System.out.println("[ " + nowMap.get(i) + " ]");
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
