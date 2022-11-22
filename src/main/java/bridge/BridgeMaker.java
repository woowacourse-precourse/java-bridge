package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private static String bridgeStr = "";

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

        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자만 입력 가능합니다.");
        }

        bridgeStr = "";     // while문에 들어가기 때문에  초기화 꼭 필요

        for (int i = 0; i < size; i++) {
            bridgeStr += bridgeNumberGenerator.generate();
        }
        System.out.println(" 다리 " + bridgeStr);

        int[][] arr = new int[2][bridgeStr.length()];
        for (int i = 0; i < bridgeStr.length(); i++) {
            if (bridgeStr.charAt(i) == '0') {
                arr[1][i] = 1;
            } else if (bridgeStr.charAt(i) == '1') {
                arr[0][i] = 1;
            }
        }

        System.out.println("BridgeMaker.makeBridge() arr 타입");
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        return changeStrToBridge(bridgeStr);
    }

    // 10110 같은 형태를 가지고 사용자가 하나씩 입력하는 값과 비교해준다.
    public String bridgeStr() {

        return bridgeStr;
    }


    // String 00111010101  => List<String> 형태로 바꾼다.
    // 10101x 이면?
    public  List<String> changeStrToBridge(String inputBridgeStr) {

        List<String> result = new ArrayList<>();
        String up = "[";
        String down = "[";

        for (int i = 0; i < inputBridgeStr.length(); i++) {


            if (inputBridgeStr.charAt(i) == '1') {

                if (i == inputBridgeStr.length() - 1) {
                    up += " O ";
                    down += "   ";
                    continue;
                }
                up += " O |";
                down += "   |";

            } else if (inputBridgeStr.charAt(i) == '0') {

                if (i == inputBridgeStr.length() - 1) {
                    down += " O ";
                    up += "   ";
                    continue;
                }
                down += " O |";
                up += "   |";

            } else if (inputBridgeStr.charAt(i) == 'x') {        // x, y => 매치 되지 않는 상황인 경우

                down += "   ";
                up += " X ";
                break;      //여기서 더이상 다리 만들기를 끝내야한다.

            } else if (inputBridgeStr.charAt(i) == 'y') {       // 밑에가 x인 경우

                    down += " X ";
                    up += "   ";
                    break;      //여기서 더이상 다리 만들기를 끝내야한다.
                }
            }

        up += "]";
        down += "]";
        result.add(up);
        result.add(down);
        return result;

    }

}
