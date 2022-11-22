package bridge;

import bridge.View.mainView;

import java.util.List;

import static bridge.BridgeGame.game_status;
import static bridge.GameController.count;
//import static bridge.GameController.round_count;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        //mainView mainview= new mainView(gameController);
        int input = gameController.inputView().readBridgeSize();
        if (input == 1) {
            System.out.println("[ERROR] 다리의 길이는 3~20이여야 합니다.");
            return;
        }
        gameController.set_bridge(input);
        if(gameController.start().equals("EXIT")){
            System.out.print("[ERROR] U,D 둘중 하나만 입력해주세요." );
            return;
        }


    }
}

