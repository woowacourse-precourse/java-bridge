package control;

import bridge.*;
import domain.BridgeGame;
import domain.BridgeMaker;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public static void main(String[] args){
        try{
            playGame();
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public static void playGame(){

        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        int gameCount = 1;
        boolean restart = true;
        boolean game = true;

        while (restart){

            game = true;
            int index = 0;

            while (game && bridgeGame.getLowerLine().size() != bridge.size()){

                game = bridgeGame.move(index, inputView.readMoving());
                index++;
                outputView.printMap(bridgeGame.getUpperLine(),bridgeGame.getLowerLine());
            }

            if (game){
                restart = false;
                break;
            }
            restart = bridgeGame.retry(inputView.readGameCommand());
            bridgeGame.refresh();
            gameCount++;

        }

        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getUpperLine(),bridgeGame.getLowerLine());
        outputView.printResult(game,gameCount);

    }
}