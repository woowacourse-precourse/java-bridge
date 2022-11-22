package bridge;

import com.sun.net.httpserver.Authenticator;

import java.util.List;

public class GameStart {

    private final BridgeGame bridgeGame;
    private  InputView inputView;
    private  OutputView outputView;
    private static int tryNum=1;
    private static boolean regame ;

    GameStart(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        inputView = new InputView();
        outputView = new OutputView();
        regame = true;
        StartMoving();
    }

}
