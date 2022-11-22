package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
//        BridgeMaker bridgeMaker = new BridgeMaker();
        OutputView outputView = new OutputView();
        List<String> bridge = null;
        int count = 0;

        try{
            bridge = bridgeGame.gameStart(inputView.readBridgeSize());    // 게임 시작
//            boolean success = true;

            int i = 0;
            while(bridgeGame.isSuccess() && i < bridge.size()){

                bridgeGame.move(bridge, inputView.readMoving(), i);
                i++;
                outputView.printMap(bridgeGame.getTempUpList(), bridgeGame.getTempDownList());
            }
            count++;
            outputView.printResult(bridgeGame.isSuccess(), bridgeGame.finalUpList(), bridgeGame.finalDownList(), count);

        } catch (IllegalArgumentException e){
        }


//        bridgeGame.move(bridge, inputView.readMoving());


    }
}
