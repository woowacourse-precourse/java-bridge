package bridge.config;

import bridge.controller.GameController;
import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.UserBridgeRepository;
import bridge.service.BridgeGame;
import bridge.service.GameService;
import bridge.service.InputValidService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
	public GameController config() {
		OutputView outputView = new OutputView();
		InputController inputController = new InputController(new InputView(), new InputValidService(), outputView);
		UserBridgeRepository userBridgeRepository = new UserBridgeRepository();
		Bridge bridge = new Bridge();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame(bridge, userBridgeRepository);
		GameService gameService = new GameService(bridgeMaker, bridge, userBridgeRepository);
		return new GameController(bridgeGame, outputView, inputController, gameService);
	}
}
