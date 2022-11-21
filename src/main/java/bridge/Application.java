package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<Integer> number = new ArrayList<>();

        System.out.println(bridgeMaker.putNumber(number,3));
    }
}
