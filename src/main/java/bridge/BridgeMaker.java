package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;
    static int now_size = 0;
    static List<String> bridge_answer = new ArrayList<>();
    static StringBuilder upBridge = new StringBuilder();
    static StringBuilder downBridge = new StringBuilder();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < size; i++) {
            int a = bridgeRandomNumberGenerator.generate();
            if (a == 0)
                bridge_answer.add("U");
            if (a == 1)
                bridge_answer.add("D");
        }
        return bridge_answer;
    }

    public void resultBridge(List<String> user_answer ) {
        System.out.println("나우 사이즈 = " + now_size);
        upBridge.setLength(0);
        downBridge.setLength(0);
        upBridge.append("[ ");
        downBridge.append("[ ");
            for (int i = 0; i < now_size + 1; i++) {
                System.out.println("브릿지 앤서 = " + bridge_answer.get(i) + ", 유저앤서 = " + user_answer.get(i));
                if (Objects.equals(bridge_answer.get(i), user_answer.get(i))) {
                    if (Objects.equals(bridge_answer.get(i), "U")) {
                        System.out.println("U 정답");
                        upBridge.append("O ");
                        downBridge.append("  ");
                    } else if (Objects.equals(bridge_answer.get(i), "D")) {
                        System.out.println("D 정답");
                        upBridge.append("  ");
                        downBridge.append("O ");
                    }
                } else {
                    if (Objects.equals(user_answer.get(i), "U")) {
                        System.out.println("U O답");
                        upBridge.append("X ");
                        downBridge.append("  ");
                    } else if (Objects.equals(user_answer.get(i), "D")) {
                        System.out.println("D O답");
                        upBridge.append("  ");
                        downBridge.append("X ");
                    }
                }
                if (now_size == i) {
                    System.out.println("U 정답 끝");
                    upBridge.append("]");
                    downBridge.append("]");
                } else {
                    System.out.println("U 정답 안끝");
                    upBridge.append("| ");
                    downBridge.append("| ");
                }
            }

            now_size++;
            showBridge();
    }
    public static void showBridge(){
        System.out.println(upBridge.toString());
        System.out.println(downBridge.toString());

    }


}
