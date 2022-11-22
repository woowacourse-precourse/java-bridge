package bridge;

import java.util.List;

public class Application {

    private static InputView inputView;
    private static BridgeGame bridgeGame;
    private static BridgeMaker bridgeMaker;
    private static OutputView outputView;
    private static boolean flag;

    public static void main(String[] args) {
        init();
        if(!generateBridge()) playGame(true);
        if(flag) gameFinish();
    }
    private static void playStage(){
        outputView.printCase("play");
        flag = calcBridge(inputView.readMoving());
        outputView.printMap(bridgeGame.calcMap(bridgeGame.getUserBridge(),0,0),new StringBuilder());
    }

    private static void playGame(boolean isPlaying){
        while(isPlaying){
            playStage();
            if(flag){
                outputView.printCase("regame");
                isPlaying = bridgeGame.retry(inputView.readGameCommand());
            }
            if(bridgeGame.isFinish()){
                gameFinish();
                break;
            }
        }
    }

    private static void gameFinish(){
        if(flag) outputView.printResult("실패",bridgeGame.calcMap(bridgeGame.getUserBridge(),0,0), bridgeGame.getTryCnt());
        else if(bridgeGame.isFinish()){
            outputView.printResult("성공",bridgeGame.calcMap(bridgeGame.getUserBridge(),0,0), bridgeGame.getTryCnt());
        }
    }

    private static boolean calcBridge(String command){
        boolean flag = false;
        List<String> curUserBridge = bridgeGame.getUserBridge();
        curUserBridge.add(command);
        if(bridgeGame.getUserBridge().size() >= 2 && !bridgeGame.move(curUserBridge.size()-1,command)){
            curUserBridge.remove(curUserBridge.size()-1);
            curUserBridge.add("X");
            flag = true;
        }
        bridgeGame.setUserBridge(curUserBridge);
        return flag;
    }

    private static boolean generateBridge(){
        outputView.printCase("init");
        int size = 0;
        try{
            size = inputView.readBridgeSize();
            bridgeGame.setBridge(bridgeMaker.makeBridge(size));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static void init(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator());
        bridgeGame.setTryCnt(1);
    }
}
