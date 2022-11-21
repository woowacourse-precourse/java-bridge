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
        List<String> bridges = bridgeMaker.makeBridge(size);    // 다리 "UDU" String 으로 List에 담김

        String correctOrFailSign="";
        int indexOfBridge=0;

        int gameTryNumber=1;
        while (gameStartOrNot){
            outputView.printUpOrDownMessage();
            String upOrDown=inputView.readMoving();
            boolean stillgameSign=bridgeGame.move(bridges.get(0), upOrDown, indexOfBridge);
            if(!stillgameSign){
                correctOrFailSign+="X";
            }else{
                correctOrFailSign+="O";
            }
            outputView.printMap(bridges.get(0), correctOrFailSign);
            if(!stillgameSign){
                outputView.printReOrStart();
                gameStartOrNot=bridgeGame.retry(inputView.readGameCommand());
                gameTryNumber++;
            }
            indexOfBridge++;
        }
        if(correctOrFailSign.contains("X")){
            outputView.printResult("실패", gameTryNumber-1);
        }else{
            outputView.printResult("성공", gameTryNumber);
        }
    }
}
