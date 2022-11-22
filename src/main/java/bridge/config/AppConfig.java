package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.GameController;
import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.repository.UserBridgeRepository;
import bridge.service.BridgeGame;
import bridge.service.InputValidService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
	public GameController config() {
		OutputView outputView = new OutputView();
		InputController inputController = new InputController(new InputView(), new InputValidService(), outputView);
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker, new Bridge(), new UserBridgeRepository());
		return new GameController(bridgeGame, outputView, inputController);
	}
}
