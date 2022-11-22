package bridge;


import java.util.ArrayList;
import java.util.List;


public class Application {

    static boolean retryYn = true;
    static int totalCnt = 0;
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    static String generatedBridgeStr = "";
    static int bridgeSize = 0;
    static List<String> resultBridge = new ArrayList<>();
    static String inputBridgeStr = "";
    static boolean successYn;
    static List<String> generatedBridge = new ArrayList<>();

    public static void startBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void initialSetting() {
        startBridgeGame();
        inputView = new InputView();
        // 랜덤으로 다리를 생성한다.
        bridgeSize = inputView.readBridgeSize();        // 다리 길이를 입력 받아서 저장한다.
        generatedBridge = bridgeMaker.customMakeBridge(bridgeSize);
        generatedBridgeStr = bridgeMaker.bridgeStr();        // 1011010111
        resultBridge = new ArrayList<>();
        inputBridgeStr = "";
        successYn = true;
    }

    public static void printRandomBridge() {
        System.out.println("generatedBridgeStr " + generatedBridgeStr);
        System.out.println("랜덤으로 생성한 브릿지");
        for (String b : generatedBridge) {
            System.out.println(b);
        }
    }

    public static void finalSetting() {
        // 최종 결과 출력
        OutputView outputView = new OutputView();
        resultBridge = bridgeMaker.changeStrToBridge(inputBridgeStr);
        outputView.printResult(resultBridge, successYn, totalCnt);
    }

    public static void main(String[] args) {
        initialSetting();
//        printRandomBridge();
        while (retryYn) {
            boolean successYn = recursiveBridgeGame();
            if (successYn) {
                break;
            }
        }
        finalSetting();
    }

    public static boolean recursiveBridgeGame() {
        successYn = true;
        ++totalCnt;
        inputBridgeStr = inputView.readMoving(generatedBridgeStr, bridgeSize);
        if (inputBridgeStr.contains("x") || inputBridgeStr.contains("y")) {
            successYn = false;
        }
        if (successYn) {
            return true;
        }
        retryYn = inputView.readGameCommand();
        return false;
    }
}
