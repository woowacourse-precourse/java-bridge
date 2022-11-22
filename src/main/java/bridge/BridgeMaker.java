package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static String up = "";
    private static String down = "";
    private static final String errorMsg = "[ERROR]";
    private static String bridgeStr = "";
    private char tmpChar = ' ';
    private boolean isFinalIdx = false;
    private int[][] tmpArr;
    private static List<String> resultBridge = new ArrayList<>();
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private  List<String> res = new ArrayList<>();


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    public void initialSetting() {
        resultBridge = new ArrayList<>();
        up = "[";
        down = "[";
    }

    public void finalSetting() {
        up += "]";
        down += "]";
        resultBridge.add(up);
        resultBridge.add(down);
    }

    // String 00111010101  => List<String> 형태로 바꾼다.
    public List<String> changeStrToBridge(String inputBridgeStr) {
        initialSetting();
        recursiveFor(inputBridgeStr, inputBridgeStr.length());
        finalSetting();
        return resultBridge;
    }

    public void recursiveFor(String inputBridgeStr, int length){

        for (int i = 0; i < inputBridgeStr.length(); i++) {
            tmpChar = inputBridgeStr.charAt(i);
            isFinalIdx = (i == inputBridgeStr.length() - 1);
            if (tmpChar == 'x' || tmpChar == 'y') {failureHandler(tmpChar, isFinalIdx);
                break;
            }
            successHandler(tmpChar, isFinalIdx);
        }

    }

    public void upSuccess(boolean isFinalIdx) {

        if (isFinalIdx) { // 업
            up += " O ";
            down += "   ";
            return;
        }
        up += " O |";
        down += "   |";
    }

    public void downSuccess(boolean isFinalIdx) {
        if (isFinalIdx) { // 다운
            up += "   ";
            down += " O ";
            return;
        }
        up += "   |";
        down += " O |";
    }

    public void upFail(boolean isFinalIdx) {
        if (isFinalIdx) {
            up += " X ";
            down += "   ";
            return;
        }
        up += " X |";
        down += "   |";
    }

    public void downFail(boolean isFinalIdx) {
        if (isFinalIdx) {
            up += "   ";
            down += " X ";
            return;
        }
        up += "   |";
        down += " X |";
    }

    public void successHandler(char tmpChar, boolean isFinalIdx) {
        if (tmpChar == '1') {
            upSuccess(isFinalIdx);
        } else if (tmpChar == '0') {
            downSuccess(isFinalIdx);
        }
    }

    public void failureHandler(char tmpChar, boolean isFinalIdx) {
        if (tmpChar == 'x') {
            upFail(isFinalIdx);
        } else if (tmpChar == 'y') {
            downFail(isFinalIdx);
        }
    }

    public void makeArr() {

        int[][] tmpArr = new int[2][bridgeStr.length()];
        for (int i = 0; i < bridgeStr.length(); i++) {
            if (bridgeStr.charAt(i) == '0') {       //  0인 경우 아래 칸 건널 수 있다.
                tmpArr[1][i] = 1;
            } else if (bridgeStr.charAt(i) == '1') {    // 0인 경우 위 칸이 건널 수 있다.
                tmpArr[0][i] = 1;
            }
        }
    }

    public void printArr() {
        System.out.println("BridgeMaker.makeBridge() arr 타입");
        for (int[] a : tmpArr) {
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * <p>
     */
    public List<String> customMakeBridge(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(errorMsg + " 3 이상 20 이하의 숫자만 입력 가능합니다.");
        }
        bridgeStr = "";     // while문에 들어가기 때문에  초기화 꼭 필요
        for (int i = 0; i < size; i++) {
            bridgeStr += bridgeNumberGenerator.generate();
        }
        makeArr();//      printArr();
        return changeStrToBridge(bridgeStr);
    }

    // 10110 같은 형태를 가지고 사용자가 하나씩 입력하는 값과 비교해준다.
    public String bridgeStr() {

        return bridgeStr;
    }



    public List<String> makeBridge(int size) {
        String inputBridgeStr = forRecursive(size);
        bridgeStr = "";
        res = new ArrayList<>();
        for (char c : inputBridgeStr.toCharArray()) {
            if (c == '1') {
                res.add("U"); continue;
            }
            res.add("D");
        }   return res;
    }

    public String forRecursive(int size) {
        String res = "";

        for (int i = 0; i < size; ++i) {
            res += bridgeNumberGenerator.generate();
        }
        return res;
    }

}
