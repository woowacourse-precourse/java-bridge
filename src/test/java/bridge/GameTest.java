package bridge;

import bridge.controller.BridgeGame;
import bridge.enums.UpDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class GameTest {
	private final int BRIDGE_SIZE = 3;
	class BridgeOnlyZeroGenerator implements BridgeNumberGenerator {
		@Override
		public int generate() {
			return 0;
		}
	}

	@DisplayName("게임 정상 테스트")
	@Test
	void normalTest(){
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
		List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		IntStream.range(0, BRIDGE_SIZE)
				.forEach(i -> bridgeGame.move(UpDown.DOWN.getStrValue()));
		Assertions.assertThat(bridgeGame.isGameWin()).isTrue();
	}

	@DisplayName("게임 예외 테스트")
	@Test
	void exceptionTest(){
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
		List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		IntStream.range(0, BRIDGE_SIZE)
				.forEach(i -> bridgeGame.move(UpDown.UP.getStrValue()));
		Assertions.assertThat(bridgeGame.isGameWin()).isFalse();
	}

	@DisplayName("다리를 못건너는 경우 종료 확인")
	@Test
	void crossWrongDirectionTest(){
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
		List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		bridgeGame.move("D");
		bridgeGame.move("D");
		bridgeGame.move("U");
		Assertions.assertThat(bridgeGame.isGameLoss()).isTrue();
	}
}
