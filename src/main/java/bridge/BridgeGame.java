package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView = new InputView();
    private  OutputView outputView = new OutputView();
    private List<String> bridge;
    private int position = 0;
    private int tryCount = 1;
    private boolean quit = false;

    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(String answer, String input) {
        if (!answer.equals(input)) {
            outputView.printMap(bridge, position+1, false);
            if (inputView.readGameCommand().equals("R")) {
                retry();
            } else {
                quit = true;
            }
        } else {
            outputView.printMap(bridge, position+1, true);
            position++;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        position = 0;
        tryCount++;
    }

    public void run() {
        while (position <= bridge.size()-1 && quit == false) {
            System.out.println(position);
            move(bridge.get(position), inputView.readMoving());
        }
        outputView.printResult();
    }
}
