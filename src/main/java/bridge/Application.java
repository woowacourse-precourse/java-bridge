package bridge;

import controller.GameController;
import view.AnnouncementView;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            AnnouncementView.start();
            int size = InputView.readBridgeSize();
            GameController.start_game(make_bridge(size), size);
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<String> make_bridge(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
}
