package bridge;
import java.util.List;


public class BridgeGame {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    static String falseOrTure = "성공";
    static int count = 1;
    static List<String> randomBridges;

    public static void move() {
        randomBridges = bridgeMaker.makeBridge(inputView.bridgeLength);   //랜덤다리 생성
        for (String randomBridge : randomBridges) {
            movingCheck(randomBridge, inputView.readMoving());            //값 비교
            if (falseOrTure.equals("실패")) {
                break;
            }
        }
        successOrFalseCheck(falseOrTure);    //성공 시 결과 출력, 실패 시 retry 구문 실행
    }
    public static String movingCheck(String randomBridge, String upAndDown){
        if(!randomBridge.equals(upAndDown)) {
            outputView.falsePrintMap(upAndDown);    //값이 다를 시 출력값에 X 삽입
            falseOrTure = "실패";
        }
        if(randomBridge.equals(upAndDown)){
            outputView.printMap(upAndDown);         //값이 같을 시 출력값에 O 삽입
        }
        return falseOrTure;
    }
    public static void successOrFalseCheck(String falseOrTure){
        if(falseOrTure.equals("성공")){   //성공 시 값 출력
            outputView.printResult(falseOrTure, count);
        }
        if(falseOrTure.equals("실패")){   //실패 시 retry 구문 실행
            retry();
        }
    }

    public static void retry() {
        String retry = inputView.readGameCommand();
        if(retry.equals("R")){
            clearAndRetry();    //재시도시 초기화 및 시도횟수 증가 후 재시도
        }
        if(retry.equals("Q")){
            outputView.printResult(falseOrTure, count);
        }
    }
    public static void  clearAndRetry(){
        outputView.init();
        randomBridges.clear();
        falseOrTure = "성공";
        count++;
        move();
    }
}
