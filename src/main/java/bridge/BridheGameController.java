package bridge;

import java.util.List;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void gameStart() {
        try {
            outputView.printgameStart();
            List<String> bridges = gameinit();
            BridgeGame bridgeGame = new BridgeGame();
            boolean restart;
            int count = 0;
            do {
                count++;
                restart = Bridgemove(bridges, bridgeGame);
            } while (restart);
            outputView.printResult(bridgeGame.getResult(), success(bridgeGame), count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public String success(BridgeGame bridgeGame) {
        if (bridgeGame.getResult().contains(List.of(Bridgelocation.UPX, Bridgelocation.DOWNX))) {
            return "실패";
        }
        return "성공";
    }


    public Boolean Bridgemove(List<String> bridges, BridgeGame bridgeGame) {
        for (String bridge : bridges) {
            String userinput = inputView.readMoving();
            bridgeGame.move(userinput, bridge);
            outputView.printMap(bridgeGame.getResult());
            if (!Utility.StringEquals(userinput, bridge)) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return false;
    }

    public List<String> gameinit() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }


}
