package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    static List<String> randomBridges;
    static String falseOrTure = "성공";
    static int count = 1;

    public static void main(String[] args) {
        try {
            inputView.readBridgeSize(); //다리길이 입력
            bridgeGameStart();          //게임 시작
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void bridgeGameStart(){
        randomBridges = bridgeMaker.makeBridge(inputView.bridgeLength);   //랜덤다리 생성
        for (String randomBridge : randomBridges) {
            movingCheck(randomBridge, inputView.readMoving());            //값 비교
            if(falseOrTure.equals("실패")){
                break;
            }
        }
        successOrFalseCheck(falseOrTure);    //성공 시 결과 출력, 실패 시 retry 구문 실행
    }
    public static void movingCheck(String randomBridge, String moving) {
        if(bridgeGame.move(randomBridge, moving) == true) {
            outputView.printMap(moving);         //값이 같을 시 출력값에 O 삽입
        }
        if (bridgeGame.move(randomBridge, moving) == false) {
            outputView.falsePrintMap(moving);    //값이 다를 시 출력값에 X 삽입
            falseOrTure = "실패";
        }
    }
    public static void successOrFalseCheck(String falseOrTure){
        if(falseOrTure.equals("성공")){   //성공 시 값 출력 후 종료하는 구문 실행
            exit();
        }
        if(falseOrTure.equals("실패")){   //실패 시 retry 구문 실행. R, Q를 입력받음
            bridgeGame.retry(inputView.readGameCommand());
        }
    }
    public static void  clearAndRetry(){
        outputView.init();
        randomBridges.clear();
        falseOrTure = "성공";
        count++;
        bridgeGameStart();
    }
    public static void exit(){
        outputView.printResult(falseOrTure, count);
    }
}
