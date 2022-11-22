package bridge.controller;

import static bridge.data.Command.QUIT;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.data.Glass;
import bridge.data.State;
import bridge.model.BridgeGame;
import bridge.view.BridgeView;
import java.util.List;

public class BridgeController extends BridgeMaker {

    private static BridgeGame model;
    private static BridgeView view;
    private static ExceptionHandler exc;

    public void initGame(){
        view.printStartMessage();
        int size = getSize();
        model = new BridgeGame(makeBridge(size));
    }

    private int getSize(){
        String size;
        try{
            size = exc.validBridgeSize(view.sizeIO());
        }
        catch (IllegalArgumentException e){
            size = exc.reEnter(view, e);
        }
        return Integer.parseInt(size);
    }

    private String getCommand(){
        String command;
        try{
            command = exc.validGameCommand(view.commandIO());
        }
        catch (IllegalArgumentException e){
            command = exc.reEnter(view, e);
        }
        return command;
    }

    public void playGame(boolean play){
        if(model.isClear()){ play = quitGame(State.SAFE); }

        if(!play) return;

        State move = getMove();
        view.printMap(model.drawMap(move));

        if(!move.ALIVE()){ play = dead(State.FAIL); }

        playGame(play);
    }

    private State getMove(){
        String nextMove;
        try{
            nextMove = exc.validMoving(view.moveIO());
        }
        catch (IllegalArgumentException e){
            nextMove = exc.reEnter(view, e);
        }
        return model.move(Glass.glassOf(nextMove));
    }

    private boolean quitGame(State state){
        String result = model.drawResult(state);
        view.printResult(result);
        return false;
    }

    private boolean retryGame(){
        model.retry();
        return true;
    }

    private boolean dead(State state){
        String command = getCommand();
        if(command.equals(QUIT.KEY())){
            return quitGame(state);
        }
        return retryGame();
    }


    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        super(bridgeNumberGenerator);

        model = new BridgeGame(List.of());
        view = new BridgeView();
        exc = new ExceptionHandler();
    }
}
