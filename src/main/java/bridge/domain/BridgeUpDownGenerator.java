package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeUpDownGenerator {

    /**
     * 위, 아래의 정보를 가진 다리를 생성하기
     */
    public static List<String> generateUpDownInformation(final int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeUpDown = bridgeMaker.makeBridge(size);

        return bridgeUpDown;
    }
}
