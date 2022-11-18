package bridge.config;

import bridge.controller.BridgeGame;
import bridge.controller.InputController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.repository.BridgeRepository;
import bridge.repository.UserBridgeRepository;
import bridge.service.GameEndService;
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
		GameService gameService = new GameService(new BridgeMaker(new BridgeRandomNumberGenerator()),
			new BridgeRepository(),
			userBridgeRepository);
		GameEndService gameEndService = new GameEndService(userBridgeRepository);
		return new BridgeGame(inputController, gameService, outputView, gameEndService);
	}
}
