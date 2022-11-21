package bridge;

import java.util.ArrayList;
import java.util.Arrays;
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
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * <p>
     */
    public List<String> makeBridge(int size) {

        List<String> bridge = new ArrayList<>();

        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자만 입력 가능합니다.");

        }

        String str = "";

        for (int i = 0; i < size; i++) {
            str += bridgeNumberGenerator.generate();
        }
        System.out.println(" 다리 " + str);

        int[][] arr = new int[2][str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                arr[1][i] = 1;
            } else if (str.charAt(i) == '1') {
                arr[0][i] = 1;
            }
        }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }


        return change(str);
    }


    public static List<String> change(String bridgeStr) {

        List<String> result = new ArrayList<>();
        String up = "[";
        String down = "[";

        for (int i = 0; i < bridgeStr.length(); i++) {

            if (bridgeStr.charAt(i) == '1') {

                if (i == bridgeStr.length() - 1) {
                    up += " O ";
                    down += "   ";
                    continue;
                }
                up += " O |";
                down += "   |";
            } else if (bridgeStr.charAt(i) == '0') {

                if (i == bridgeStr.length() - 1) {
                    down += " O ";
                    up += "   ";
                    continue;
                }
                down += " O |";
                up += "   |";
            }
        }

        up += "]";
        down += "]";
        result.add(up);
        result.add(down);
        return result;

    }

}
