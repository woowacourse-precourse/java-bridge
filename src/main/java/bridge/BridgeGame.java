package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final BridgeNumberGenerator gen;
    final BridgeMaker bm;
    final List<String> map;
    final OutputView out;
    private int bridgeLength;
    private int trials = 0;
    private List<String> user = new ArrayList<>();

    public BridgeGame(OutputView out, int bridgeLength) {
        this.out = out;
        this.bridgeLength = bridgeLength;
        this.gen = new BridgeRandomNumberGenerator();
        this.bm = new BridgeMaker(gen);
        this.map = bm.makeBridge(bridgeLength);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        user.add(direction);
        out.printMap(map,user);

        if (direction != map.get(user.size()-1)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.user = new ArrayList<>();
        this.trials += 1;
    }

    public boolean isFinished(){
        return user.size() == bridgeLength;
    }

    public void finish(){
        out.printResult(map.equals(user),trials);
    }


}
