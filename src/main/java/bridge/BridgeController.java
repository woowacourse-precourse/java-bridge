package bridge;

import bridge.domain.bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public static int tryNumber = 0;
    private int size;
    void init(){
        try {
            outputView.startPrint();
            size = inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            init();
            return;
        }
        bridgeInit();
    }
    void bridgeInit(){
        try {
            bridgeGame.makeBridge(size);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeInit();
            return;
        }
        run();
    }
    void run(){
        tryNumber++;
        for (int i = 0 ;i<size;i++) {
            makePlayer();
            if (movePlayer(i)){
                continue;
            }
            if (retryPlayer()){
                run();
                return;
            }
        }
        bridgeGame.endGame();
    }
    void makePlayer(){
        try {
            outputView.gamePrint();
            bridgeGame.setPlayer(inputView.readMoving());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makePlayer();
            return;
        }
    }
    boolean movePlayer(int index){
        return bridgeGame.move(index);
    }
    boolean retryPlayer(){
        try {
            return bridgeGame.retry();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return retryPlayer();
        }
    }
}
