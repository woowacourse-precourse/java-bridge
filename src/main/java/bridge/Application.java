package bridge;


import java.util.List;


public class Application {

    static boolean retryYn = true;  // 종료를 선택하면 false로 바꿔준다.
    static int totalCnt = 0;


    public static void startBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startBridgeGame();
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        // 1) 랜덤으로 다리를 생성한다.
        int bridgeSize = inputView.readBridgeSize();        // 다리 길이를 입력 받아서 저장한다.
        List<String> generatedBridge = bridgeMaker.customMakeBridge(bridgeSize);
        String generatedBridgeStr = bridgeMaker.bridgeStr();        // 1011010111

        /*
        System.out.println("generatedBridgeStr " + generatedBridgeStr);
        System.out.println("랜덤으로 생성한 브릿지");
        for (String b : generatedBridge) {
            System.out.println(b);
        }
        */

        List<String> resultBridge;

        String inputBridgeStr = "";
        boolean successYn = true;

        while (retryYn) {

            successYn = true;
            ++totalCnt;
            // 2) 다리 게임
            inputBridgeStr = inputView.readMoving(generatedBridgeStr,
                bridgeSize);   // 생성한 다리 정보를 넣어준다
//            System.out.println("==============================  사용자 입력 inputBridgeStr " + inputBridgeStr);

            if (inputBridgeStr.contains("x") || inputBridgeStr.contains("y")) {
                successYn = false;
            }

            if (successYn) {
                break;
            }
            // 3) 실패했으면 게임을 재시작할지 종료할 지 정한다.
            retryYn = inputView.readGameCommand();

        }

        // 맨 마지막에만 최종 결과 출력
        OutputView outputView = new OutputView();
        resultBridge = bridgeMaker.changeStrToBridge(inputBridgeStr);
        outputView.printResult(resultBridge, successYn, totalCnt);


    }
}
