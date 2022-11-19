package bridge.bridge;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class BridgeGame {

    private List<String> bridge = new ArrayList<>();

    /**
     * 다리를 생성하는 메서드입니다.
     * @param size 다리의 크기
     */
    public void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드입니다.
     * 옳은 길을 선택한 경우, 게임 결과를 출력하고 성공한 경우에 해당하는 메서드가 실행됩니다.
     * 틀린 길을 선택한 경우, 게임 결과를 출력하고 실패한 경우에 해당하는 메서드가 실행됩니다.
     * @param direction 사용자가 입력한 방향
     * @param cellIndex 현재 몇 번째 칸인지를 표현하는 index
     */
    public void move(String direction, int cellIndex) {
        if (bridge.get(cellIndex).equals(direction)) {
            printResult(cellIndex, true);
            moveSuccess();
            return;
        }
        printResult(cellIndex, false);
        moveFail();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {

    }

    private void moveSuccess() {

    }

    private void moveFail() {

    }

    private void printResult(int currentIndex, boolean isSuccess) {

    }
}
