package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeCommandControllerTest {
	private static BridgeCommandController bridgeCommandController;

	@BeforeAll static void initialize() {
		BridgeGame bridgeGame = new BridgeGame();
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		bridgeCommandController = new BridgeCommandController(bridgeGame, inputView, outputView);
	}

	@DisplayName("커맨드가 R이 맞는 경우") @Test void commandTest1() {
		Assertions.assertThat(bridgeCommandController.isCommandRetry("R")).isTrue();
	}

	@DisplayName("커맨드가 R이 아닌 경우") @Test void commandTest2() {
		Assertions.assertThat(bridgeCommandController.isCommandRetry("Q")).isFalse();
	}
}
