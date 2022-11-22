package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeState;
import bridge.domain.GameAttempt;
import bridge.domain.Round;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;

public class Config {

    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private Round round;
    private GameAttempt gameAttempt;
    private BridgeState bridgeState;
    private BridgeGame bridgeGame;
    private View view;

    public Config() {
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.view = new View(new InputView(), new OutputView());
        this.round = new Round();
        this.gameAttempt = new GameAttempt();
        this.bridgeState = new BridgeState(round);
        this.bridgeGame = new BridgeGame(round, gameAttempt, bridgeState);
    }

    public BridgeGameController setBridgeGameController() {
        return new BridgeGameController(view, bridgeGame, bridgeMaker);
    }
}
