package bridge;

import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private static final String RETRY_COMMAND = "R";
    private BridgeGame bridgeGame;

    public BridgeGameService() {
    }

    public void init(){
        bridgeGame = makeBridgeGame();

        startGame();

        OutputView.printResult(bridgeGame, bridgeGame.isGameSuccess());
    }

    public void startGame(){
        boolean keepGoing = true;
        while (keepGoing){
            boolean crossSuccess = move();
            OutputView.printMap(bridgeGame);

            keepGoing = getNextStep(crossSuccess);
        }
    }

    /**
     * move로 이동한 후, 케이스를 나눠 다음 행동을 결정한다.
     * 게임을 끝내는 경우
     *  1. 다리를 다 건너 게임이 성공한 경우
     *  2. retry시에 종료(Q)한 경우
     *
     * 게임을 계속 진행하는 경우
     *  1. 다리를 성공적으로 건넌 경우
     *  2. retry시에 재시도(R)한 경우
     *
     * @param crossSuccess: move로 다리 건너기에 성공했는지 여부
     * @return 게임이 끝났다면 false, 게임이 계속 진행가능하다면 true
     */
    private boolean getNextStep(boolean crossSuccess){
        if (isGameSuccess()) return false;
        if (crossSuccess) return true;
        if (isRetry()) {
            retry();
            return true;
        }
        return false;
    }

    public BridgeGame makeBridgeGame(){
        List<String> bridge = makeBridge();
        Player player = makePlayer();

        return new BridgeGame(bridge, player);
    }
    public List<String> makeBridge(){
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = getBridgeMaker().makeBridge(bridgeSize);

        return bridge;
    }
    public Player makePlayer(){
        return new Player();
    }

    public boolean move(){
        String command = InputView.readMoving();
        return bridgeGame.move(command);
    }

    public void retry(){
        bridgeGame.retry();
    }

    public boolean isGameSuccess(){
        return bridgeGame.isGameSuccess();
    }

    public boolean isRetry(){
        String command = InputView.readGameCommand();
        return command.equals(RETRY_COMMAND);
    }

    private BridgeMaker getBridgeMaker(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

}
