package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //public InputView input = new InputView();
    //public BridgeNumberGenerator bridgeNumberGenerator;
    //public BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            List<Integer> list = new ArrayList<>();
            list.add(5);
            list.add(13);
            list.add(266);
            list.set(2, 124231);
            bridgeGame.gameStart();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + " 잘못된 입력입니다.");
        }
        /*
        try {
            bridgeGame.playGame(bridge);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + " 잘못된 입력입니다.");
        }
        */




    }
}
