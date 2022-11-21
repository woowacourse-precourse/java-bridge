package bridge;

import java.util.List;

public class GameService {
    public void playGame(){
        boolean gameStartOrNot=true;
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStartString();              //시작 멘트 출력

        int size=inputView.readBridgeSize();        //다리 길이 입력
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(size);    // 다리 "UDU" String 으로 List에 담김


        while (gameStartOrNot){
            if(!bridgeGame.move()){
                gameStartOrNot= bridgeGame.retry();
            }else{

            }
        }
    }
}
