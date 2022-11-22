package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    /*
    public List<String> makeBridge(int size) {
        System.out.println("여기");
        List<String> bridges = new ArrayList<>();

        for(int num = 0; num < size; num++){
            //double ran = Math.random()*2;
            //generate();
            //int rand =  (int) ran;
            int rand = bridgeNumberGenerator.generate();
            System.out.println("rand: " + rand);
            // 0이면 U, 1이면 D
            if(rand == 1){
                bridges.add("U");
            }
            if(rand == 0){
                bridges.add("D");
            }
        }
        return bridges;
    }
     */


    public List<String> makeBridge(int size) {
        System.out.println("he" + "size:" + size);

        List<String> bridge = new ArrayList<>();
        fillBridgeState(bridge, size);
        return bridge;
    }

    public void fillBridgeState(List<String> tmpBridge, int size) {
        for (int i = 0; i < size; i++) {
            int num = bridgeNumberGenerator.generate();
            if (num == 1) {
                tmpBridge.add("U");
            }
            if (num == 0) {
                tmpBridge.add("D");
            }
        }
    }
/*
    public List<String> makeBridge(int size) {
        List<String> converter = List.of("D", "U");
        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(converter::get)
                .collect(Collectors.toList());
    }

 */

}
