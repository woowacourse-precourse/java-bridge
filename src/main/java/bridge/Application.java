package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean success = true;
        Controller controller = new Controller();
        BridgeGame bridgeGame = controller.start();
        while(true){
            controller.play(bridgeGame);
            if (bridgeGame.check()){
                break;
            }
        }
        controller.result(bridgeGame, success);

        /*
        BridgeRandomNumberGenerator Generator = new BridgeRandomNumberGenerator();
        BridgeMaker test = new BridgeMaker(Generator);
        System.out.print(test.makeBridge(4));

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        if (size != 0){
            System.out.println(size);
        }
        String moving = inputView.readMoving();
        if (moving != null){
            System.out.println(moving);
        }
        String command = inputView.readGameCommand();
        if (command != null){
            System.out.println(command);
        }

        OutputView outputView = new OutputView();
        outputView.printStart();*/
    }
}
