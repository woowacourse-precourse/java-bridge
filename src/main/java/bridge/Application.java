package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final BridgeGame game = new BridgeGame();
        // TODO: 프로그램 구현
        try{
            game.start();

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
