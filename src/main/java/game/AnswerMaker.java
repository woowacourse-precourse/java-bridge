package Game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;

import java.util.List;

public class Print {
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.\n");
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println("bridge = " + bridge);

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputCommand = inputView.readMoving();
        System.out.println("inputCommand = " + inputCommand);

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryCommand = inputView.readGameCommand();
        System.out.println("retryCommand = " + retryCommand);
    }
}
