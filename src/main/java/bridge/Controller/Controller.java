package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public InputView inputView;
    public BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker bridgeMaker;
    public OutputView outputView;
    public BridgeGame bridgeGame;
    public void run(){
        inputView = new InputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        outputView = new OutputView();
        
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        //다리 길이 입력 받기
        int bridgeLen = inputView.readBridgeSize();

        //다리 생성하기
        List<String> bridge = bridgeMaker.makeBridge(bridgeLen);

        bridgeGame = new BridgeGame(bridge, bridgeLen);
        //게임 시작
        int gameTryCount = 1;
        boolean gameSuccess = false;
        List<String> mySelectBridge = new ArrayList<>();
        while(true){
            int position = mySelectBridge.size();
            String moving = inputView.readMoving();
            mySelectBridge.add(moving);

            if(mySelectBridge.get(position).equals(bridge.get(position))){
                //성공
                if(position == bridgeLen - 1){
                    gameSuccess = true;
                    System.out.println("최종 게임 결과");
                    outputView.printMap(bridge, true, position);
                    break;
                }
                outputView.printMap(bridge, true, position);
            }
            else{
                //실패
                outputView.printMap(bridge, false, position);
                String gameCommand = inputView.readGameCommand();

                if(gameCommand.equals("R")){
                    gameTryCount += 1;
                    mySelectBridge = new ArrayList<>();
                }
                else{
                    break;
                }
            }
        }

        //결과 출력
        outputView.printResult(gameSuccess, gameTryCount);
    }

}
