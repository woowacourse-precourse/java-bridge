package bridge.controller;

import bridge.*;

import java.util.List;

public class Controller {

    private static InputView inputView;
    private static OutputView outputView;
    private BridgeGame bridgeGame;
    private SingleMap singleMap;

    public Controller(){
        inputView=new InputView();
        outputView=new OutputView();
    }
    public void startProgram(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    //아직 커밋안함
    public void startGame(){
        int size=inputView.readBridgeSize();
        try {
            makeBridge(size);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
            makeBridge(size);
        }
    }

    private void makeBridge(int size){
        List<String> bridge=new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        bridgeGame=new BridgeGame(bridge);
    }

    public boolean playGame(){
        bridgeGame.retry();
        do{
            String move=inputView.readMoving();
            bridgeGame.move(move);
            singleMap=new SingleMap(bridgeGame,move);
            printMap();
        }while(bridgeGame.isSuccess()&&bridgeGame.checkNotGoal());
        return bridgeGame.isSuccess();
    }

    private void printMap(){
        outputView.printMap(singleMap.convertToSingleMap("U"));
        outputView.printMap(singleMap.convertToSingleMap("D"));
        System.out.println();
    }

    public boolean askRestart(){
        String command=inputView.readGameCommand();
        if(command.matches("R")){
            return true;
        }
        return false;
    }

    public void printResult(){
        outputView.printResult(singleMap);
    }

}
