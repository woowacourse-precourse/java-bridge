package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import static bridge.view.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        System.out.println(user.makeBridge(readBridgeSize()));
    }
}
