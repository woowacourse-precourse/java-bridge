package bridge;

import bridge.service.Service;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final Service service = new Service();
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
            service.makeBridge(size);
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
            service.makePlayer();
            if (service.movePlayer(i)){
                continue;
            }
            if (service.retryPlayer()){
                run();
                return;
            }
        }
        service.endGame();
    }
}
