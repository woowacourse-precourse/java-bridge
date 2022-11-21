package bridge.domain;

import bridge.util.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeGame {

    ViewController viewController;
    BridgeMaker bridgeMaker;
    List<String> bridge;
    int count;
    int bridgeIndex;
    boolean isSuccess;

    public void init(){
        viewController = new ViewController();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        count = 1;
        bridgeIndex = 0;
        isSuccess = true;
    }

    public void run(){
        makeBridge();
        do{
            int result = move(bridgeIndex);
            if (result == 1)
                bridgeIndex++;
            if (result == 0)
                retry();
        }while(isSuccess ==true && bridgeIndex < bridge.size());
        viewController.printResult(isSuccess, count);
    }

    public void makeBridge(){
        init();
        viewController.printBeginning();
        int bridgeSize = viewController.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public int move(int index) {
        String answer = viewController.readMoving();
        if(bridge.get(index).equals(answer)){
            viewController.printMap(bridge, index+1, true);
            return 1;
        }
        if(!bridge.get(index).equals(answer))
            viewController.printMap(bridge, index+1, false);
        return 0;
    }

    public void retry() {
        String command = viewController.readGameCommand();
        if(command.equals("R")){
            bridgeIndex = 0;
            count++;
        }
        if(command.equals("Q")){
            isSuccess = false;
        }
    }

}
