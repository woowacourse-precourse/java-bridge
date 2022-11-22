package bridge.View;

import bridge.InputView;
import bridge.OutputView;

import java.util.List;

//View
public class BridgeView {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        System.out.println("다리의 개수를 입력해주세요.");
        return inputView.readBridgeSize();
    }

    public String readNextStep() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return inputView.readMoving();
    }

    public void printMap(List<String> bridge, int currentStep, boolean die) {
        System.out.println(outputView.printMap(bridge, currentStep, die));
    }

    public String readRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.readGameCommand();
    }


}
