package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputManager = new InputView();

    private final OutputView outputView = new OutputView();

    private List<String> bridge;

    private List<String> movingList = new ArrayList<>();

    public List<String> getBridge() {
        return bridge;
    }

    public void gameStart() {
        printStartMessage();
        while (true) {
            try {
                int bridgeSize = inputManager.readBridgeSize();
                bridge = bridgeMaker.makeBridge(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
        }
    }

    private void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (true){
            try {
                 movingList.add(inputManager.readMoving());
                 outputView.printMap(movingList);
                 break;
            }catch (IllegalArgumentException e){System.out.println(e.getMessage());}
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
