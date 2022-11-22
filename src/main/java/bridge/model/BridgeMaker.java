package bridge.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static BridgeNumberGenerator bridgeNumberGenerator = null;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public static ArrayList<String> makeBridge(int size) {
        ArrayList<String> bridges = new ArrayList<>();
        for(int num = 0; num < size; num++){
            double ran = Math.random()*2;
            //generate();
            //int rand =  (int) ran;
            int rand = bridgeNumberGenerator.generate();
            //System.out.println("rand: " + rand);
            // 0이면 U, 1이면 D
            if(rand == 1){
                bridges.add("U");
            }else if(rand == 0){
                bridges.add("D");
            }
        }
        return bridges;
    }

}
