package bridge.BridgeGame;

import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    // To do : Main 메서드에서 주입하는 것으로 수정하기
    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(generator);
    List<String> bridge;
    OutputView outputView;
    public BridgeGame(){
        System.out.println("다리 건너기 게임을 시작 합니다.\n");
        initBridge();
        this.outputView = new OutputView(bridge);
    }

    private void initBridge() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int currentLocation) {
        System.out.println("이동할 칸을 선택해주세요. (위 : U, 아래 : D)");
        String move = inputView.readMoving();
        return outputView.printMap(currentLocation, move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요 (재시도 : R, 종료 : Q)");
        String retry = inputView.readGameCommand();

        if(retry.charAt(0) == 'R') return true;

        return false;
    }

    public void printResult(boolean flag, int count){
        this.outputView.printResult(flag, count);
    }

    public int getBridgeSize() {
        return this.bridge.size();
    }

    public void clear(){
        this.outputView.clear();
    }
}
