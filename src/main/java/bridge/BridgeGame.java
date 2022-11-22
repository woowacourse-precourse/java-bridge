package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int numberOfTry = 1;
    InputView input = new InputView();
    OutputView output = new OutputView();
    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator(); //
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator); // 인자로 인터페이스 넣음

    /*
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    */
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String direction = input.readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        numberOfTry += 1;
    }

    public void gameStart() {
        output.printGameStart();
    }
    public void playGame(){
        gameStart();
        int sizeOfBridge = input.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(sizeOfBridge);
        System.out.println(bridge);
        //[ O ]
        //[ O |O ]
        //[ O |   ]
        //[   | O ]
    }
}
