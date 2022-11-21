package bridge;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public ArrayList<String> bridge = new ArrayList<>();
    public ArrayList<String> currentCoordinate = new ArrayList<>();
    public int bridgeCount = 0;
    public int gameCount = 0;
    public boolean gameOver = false;
    public boolean completeBridge = false;
    public boolean retry = true;
    OutputView bridgeShape = new OutputView();
    public void makeBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = bridgeMaker.makeBridge(size);
        System.out.println(this.bridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        this.currentCoordinate.add(moving);
        bridgeCheck();
    }

    public void bridgeCheck() {
        System.out.println(this.bridge);
        System.out.println(this.currentCoordinate);
        if (Objects.equals(this.bridge,this.currentCoordinate)){
           bridgeShape.printResult(bridgeCount,currentCoordinate);
            System.out.println("일치");
           this.completeBridge = true;
           return;
        }
       if (!Objects.equals(this.bridge.get(bridgeCount), this.currentCoordinate.get(bridgeCount))) {
           bridgeShape.printFailed(bridgeCount, currentCoordinate);
           this.gameOver = true;
           return;
       }
       bridgeShape.printMap(bridgeCount, currentCoordinate);
       bridgeCount += 1;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String restart) {
        if (Objects.equals(restart, "Q")){
            this.retry = false;
        }
        if (Objects.equals(restart, "R")){
            this.gameCount += 1;
            int lastChar = currentCoordinate.size()-1;
            this.currentCoordinate.remove(lastChar);
        }
    }
}
