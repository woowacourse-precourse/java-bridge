package bridge.bridge;

import bridge.BridgeRandomNumberGenerator;
import bridge.output.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;
    private List<String> bridge;
    private final List<String> userInput;

    public BridgeGame(OutputView outputView) {
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new ArrayList<>();
        this.userInput = new ArrayList<>();
    }

    /**
     * 다리를 생성하는 메서드입니다.
     * @param size 다리의 크기
     */
    public void makeBridge(int size) {
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
        userInput.add(direction);
        outputView.printMap(bridge, userInput);
        if (bridge.get(cellIndex).equals(direction)) {
            moveSuccess(cellIndex);
            return;
        }
        moveFail();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {

    }

    private void moveSuccess(int cellIndex) {

    }

    private void moveFail() {
    }
}
