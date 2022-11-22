package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridge;
    private List<String> up = new ArrayList<>();
    private List<String> down = new ArrayList<>();
    private int round = 0;
    private String input;

    public void init() {
        OutputView.startGameMessage();
        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while(round != bridge.size()){
            OutputView.movePrint();
            input = inputView.readMoving();
            if(!comparingInputBridge()) {
                wrongCase();
                OutputView.printMap(this.up, this.down);
            }
            if(comparingInputBridge()){
                correctCase();
                OutputView.printMap(this.up, this.down);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean comparingInputBridge() {
        return this.input.equals(bridge.get(round));
    }

    public void correctCase() {
        round++;
        if (input.equals("U")) {
            up.add(" O ");
            down.add("   ");
            return;
        }
        up.add("   ");
        down.add(" O ");
    }

    public void wrongCase() {
        if (input.equals("U")) {
            up.add(" X ");
            down.add("   ");
            return;
        }
        up.add("   ");
        down.add(" X ");
    }
}
