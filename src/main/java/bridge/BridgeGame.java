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
    public int gameCount = 1;
    public boolean gameOver = false;
    public boolean completeBridge = false;
    public boolean retry = true;
    OutputView bridgeShape = new OutputView();
    public void makeBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public void move(String moving) {
        this.currentCoordinate.add(moving);
        bridgeCheck();
    }

    public void bridgeCheck() {
        if (Objects.equals(this.bridge,this.currentCoordinate)){
           bridgeShape.printResultMap(currentCoordinate,gameCount);
           bridgeShape.printFinalResult(currentCoordinate,gameCount);
           this.completeBridge = true;
           return;
        }
       if (!Objects.equals(this.bridge.get(bridgeCount), this.currentCoordinate.get(bridgeCount))) {
           bridgeShape.printFailedMap(currentCoordinate,bridgeCount);
           this.gameOver = true;
           return;
       }
        bridgeShape.printMap(bridgeCount, currentCoordinate);
        bridgeCount += 1;
    }

    public void retry(String restart) {
        if (Objects.equals(restart, "Q")){
            this.retry = false;
            bridgeShape.printFinalFailed(currentCoordinate,gameCount);
        }
        if (Objects.equals(restart, "R")){
            this.gameCount += 1;
            int lastChar = currentCoordinate.size()-1;
            this.currentCoordinate.remove(lastChar);
        }
    }
}
