package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        InputView input = new InputView();
        int bSize = input.readBridgeSize();
        BridgeNumberGenerator num = new BridgeRandomNumberGenerator();
        BridgeMaker makeBridge = new BridgeMaker(num);
        List<String> bridge = makeBridge.makeBridge(bSize);
        BridgeGameManage manage = new BridgeGameManage();
        String [] result = manage.manage(bridge,bSize);
        manage.out.printResult(result[0],result[1]);
    }
}
