package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridge;
    static int position;
    final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    final InputView inputView = new InputView();

    public void startGame(){
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        position = -1;
        while(position < bridgeSize - 1)
        {
            System.out.println(position + " " + bridgeSize);
            move();
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        boolean dead = false;

        String userDirection = inputView.readMoving();
        String correctDirection = bridge.get(position + 1);
        if(!userDirection.equals(correctDirection)) dead = true;

        OutputView outputView = new OutputView();
        outputView.printMap(userDirection, dead);
        if(dead) retry();

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String command = inputView.readGameCommand();
        if(command.equals("R")) position = -1;
        if(command.equals("Q")) System.exit(0);
    }
}
