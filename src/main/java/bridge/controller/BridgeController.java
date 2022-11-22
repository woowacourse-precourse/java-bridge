package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.generator.BridgeMaker;
import bridge.domain.GameCommand;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import bridge.input.*;
import bridge.input.validate.BasicBridgeValidator;
import bridge.input.validate.BridgeValidator;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.GameCommand.*;
import static bridge.controller.GameState.*;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame game;

    public BridgeController() {
        BridgeValidator bridgeValidator = new BasicBridgeValidator();
        BridgeInput bridgeInput = new ConsoleBridgeInput();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        this.inputView = new InputView(bridgeInput, bridgeValidator);
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator, bridgeValidator);
    }

    public BridgeController(BridgeInput bridgeInput, BridgeNumberGenerator bridgeNumberGenerator, BridgeValidator bridgeValidator) {
        this.inputView = new InputView(bridgeInput, bridgeValidator);
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator, bridgeValidator);
    }

    public void start() {
        outputView.printStartMessage();
        game = init();
        play();
    }

    public void play() {
        do {
            outputView.guideInputMoving();
            String moving = inputView.readMoving();
            game.move(moving);
            outputView.printMap(this.game);
        } while (game.checkGameState() == RUN);
        confirmState();
    }

    public void confirmState() {
        final GameState state = game.getState();
        if (state == FAIL) {
            outputView.guideInputGameOver();
            choiceRestartOrQuit();
        } else if (state == CLEAR) {
            end(CLEAR.getComment());
        }
    }

    private void choiceRestartOrQuit() {
        String command = inputView.readGameCommand();
        GameCommand gameCommand = parseCommandToInstance(command);
        if (gameCommand == RESTART) {
            game.retry();
            play();
        } else if (gameCommand == QUIT) {
            end(FAIL.getComment());
        }
    }

    public void end(final String result) {
        outputView.printResult(result, this.game);
    }

    public BridgeGame init() {
        Player player = initPlayer();
        Bridge bridge = initBridge();
        return new BridgeGame(player, bridge);
    }

    private Player initPlayer() {
        return new Player();
    }

    private Bridge initBridge() {
        outputView.guideInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridge);
    }

    public void setGame(final BridgeGame game) {
        this.game = game;
    }
}
