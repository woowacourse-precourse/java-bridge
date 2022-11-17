package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     *
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 Frame [  |  |  ]
     */
    private List<String> makeBridgeFrame(int size) {
//        List<String> frame1 = new ArrayList<>();
//        List<String> frame2 = new ArrayList<>();
//        frame1.add("[ O |  | O ]");
//        frame2.add("[  | O |  ]");
//        for (String s : frame1) {
//            System.out.println(s);
//        }
//
//        for (String s : frame2) {
//            System.out.println(s);
//        }
        return null;
    }
    // private List<String makeBridgeAblePosition()

    /** 
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> upAndDown = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < size; i++) {
            number = bridgeNumberGenerator.generate();
            if (number == 1) {
                upAndDown.add("U");
            } else if (number == 0) {
                upAndDown.add("D");
            }
        }
        return upAndDown;
    }
}
