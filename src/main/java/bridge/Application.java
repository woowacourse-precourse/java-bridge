package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrintCommand printCommand= new PrintCommand();
        BridgeGame game = new BridgeGame();
        InputView input = new InputView();
        BridgeNumberGenerator numGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker= new BridgeMaker(numGenerator);

        printCommand.gameStart();
        int bridgeLength=input.readBridgeSize();
        List<String> bridgeRoute = bridgeMaker.makeBridge(bridgeLength);
        game.bridgeRoute=bridgeRoute;
        game.trialCount+=1;

        gameSet(game,bridgeLength);



    }
    public static boolean gameMove(BridgeGame game,int bridgeLength){
        InputView input = new InputView();
        Boolean isSuccess;
        for(int loop=0;loop<bridgeLength;loop++){
            isSuccess=game.move(input.readMoving(),loop);
            if(!isSuccess){
                return false;
            };
        }
        return true;
    }
    public static void gameSet(BridgeGame game,int bridgeLength){
        InputView input=new InputView();
        Boolean isQuit;
        Boolean isSuccess;
        while(true){
            isSuccess=gameMove(game,bridgeLength);
            if(isSuccess){
                break;
            }
            isQuit=game.retry(input.readGameCommand());
            if(isQuit){
                break;
            }
        }
    }


}
