package bridge;


import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputs = new InputView(); // 다리 입력 길이 객체
        OutputView outputs = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator(); // 난수 생성 객체
        BridgeMaker newBridge = new BridgeMaker(bridgeNumberGenerator); // 난수를 이용한 다리 빌딩 객체
        List<String> newWholeBridge = new ArrayList<>(); // 빌드한 다리 저장 객체
        BridgeGame bridgeGame = new BridgeGame();
        boolean stageResult;
        boolean retry = true;
        int triedCounter = 0;

        List<String> currentResult = new ArrayList<>();
        List<String> currentResultNextLine= new ArrayList<>();
        int size = inputs.readBridgeSize(); //다리 길이 입력
        newWholeBridge = newBridge.makeBridge(size); // 입력 받은 길이의 다리 빌드
        System.out.println(newWholeBridge); // 다리 출력 (디버그)

        while(retry){
            retry = false;

            for(int round = 0; round<size; round++){
                String userAnswer = inputs.readMoving();
                stageResult = bridgeGame.move(userAnswer, newWholeBridge, round);

                currentResult= outputs.printMap(newWholeBridge,currentResult,stageResult,round);

                System.out.println(currentResult);
            }
            System.out.println("재시도 하시겠습니까?");
            String retryAnswer = inputs.readGameCommand();
            if(retryAnswer.equals("R") ){
                retry = true;
                triedCounter++;
            }
            if(retryAnswer == "Q"){
                break;
            }


        }




    }
}
