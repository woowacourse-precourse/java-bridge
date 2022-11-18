package bridge;

import bridge.model.Bridge;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameLogic {
    private static BridgeGame bridgeGame;
    private static InputView inputView;
    private static OutputView outputView;
    private static User user;
    private static Bridge bridge;
    public GameLogic(){
        inputView = new InputView(new InputConsole());
        user = new User();
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
    }
    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        System.out.println(bridge.getBridgeList());
        play();
    }

    private static void play(){
        if(endGame()){
            restartLogic(inputView.readGameCommand());
            return;
        }
        bridgeGame.move(bridge,user,inputView.readMoving());
        outputView.printMap(bridge,user);
        play();
    }
    private static void restartLogic(String input){
        if(bridgeGame.retry(input)) {
            user.resetUser();
            play();
            return;
        };
    }
    private static boolean endGame(){
        return !user.getResult()|user.getPosition().equals(bridge.getBridgeSize());
    }
}
