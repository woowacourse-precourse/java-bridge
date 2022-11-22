package bridge;

import java.util.List;

public class GameService {
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static ErrorCheck errorCheck=new ErrorCheck();

    public void playGame(int size){
        boolean gameStartOrNot=true;

        List<String> bridges = bridgeMaker.makeBridge(size);    // 다리 "UDU" String 으로 List에 담김

        String correctOrFailSign="";
        int indexOfBridge=0;

        int gameTryNumber=1;
        while (gameStartOrNot){
            if(indexOfBridge>=size){
                break;
            }
            outputView.printUpOrDownMessage();
            String upOrDown=inputView.readMoving();
            boolean stillgameSign=bridgeGame.move(bridges, upOrDown, indexOfBridge);
            if(!stillgameSign){
                correctOrFailSign+="X";
            }else{
                correctOrFailSign+="O";
            }
            outputView.printMap(bridges, correctOrFailSign);
            if(!stillgameSign){
                outputView.printReOrStart();
                gameStartOrNot=bridgeGame.retry(inputView.readGameCommand());
                gameTryNumber++;
            }
            indexOfBridge++;
        }
        outputView.printfinalResult();
        outputView.printMap(bridges, correctOrFailSign);
        if(correctOrFailSign.contains("X")){
            outputView.printResult("실패", gameTryNumber-1);
        }else{
            outputView.printResult("성공", gameTryNumber);
        }
    }
}
