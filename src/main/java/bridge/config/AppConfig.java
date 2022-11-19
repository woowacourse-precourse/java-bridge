package bridge.config;

import bridge.controller.BridgeGame;
import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.UserBridgeRepository;
import bridge.service.GameService;
import bridge.service.InputValidService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
	public BridgeGame config() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		InputController inputController = new InputController(inputView, new InputValidService(), outputView);
		UserBridgeRepository userBridgeRepository = new UserBridgeRepository();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		GameService gameService = new GameService(bridgeMaker, new Bridge(), userBridgeRepository);
		return new BridgeGame(inputController, gameService, outputView);
	}
}
