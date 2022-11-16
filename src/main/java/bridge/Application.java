package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView=new InputView();
    private static final OutputView outputView=new OutputView();
    private static final BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());

    private static int round=0;
    public static void main(String[] args) {
        outputView.printGameStart();
        int bridgeSize=inputView.readBridgeSize();
        List<String> bridge=bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame=new BridgeGame(bridgeSize, bridge);
        while(true){
            if(playGame(bridgeSize, bridgeGame).equals(GameState.SUCCESS)){
                break;
            }
            if(inputView.readGameCommand().equals("Q")){    //재시도를 원하는 경우
                break;
            }
            bridgeGame.retry(); //초기화
        }
        outputView.printResult(round+1,bridgeGame);



    }
    public static GameState playGame(int bridgeSize, BridgeGame bridgeGame){
        round=0;
        for(;round<bridgeSize;round++){
            String cmd=inputView.readMoving();
            boolean isSuccess=bridgeGame.move(round, cmd);
            outputView.printMap(round+1,bridgeGame.getCurrentBridge());
            if(!isSuccess){
                return GameState.FAIL;
            }
        }
        return GameState.SUCCESS;


    }
}
