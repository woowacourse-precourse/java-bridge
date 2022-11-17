package bridge;

import bridge.controller.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class GameTest {
//	class BridgeOnlyZeroGenerator implements BridgeNumberGenerator {
//		@Override
//		public int generate() {
//			return 0;
//		}
//	}
//
//	@DisplayName("게임 정상 테스트")
//	@Test
//	void normalTest(){
//		final int SIZE = 3;
//		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
//		List<String> bridge = bridgeMaker.makeBridge(SIZE);
//		BridgeGame bridgeGame = new BridgeGame(bridge);
//		IntStream.range(0, SIZE)
//				.forEach(i -> bridgeGame.move());
//		Assertions.assertThat(bridgeGame.gameEnd()).isEquals(true);
//	}
//
//	@DisplayName("게임 예외 테스트")
//	@Test
//	void normalTest(){
//		final int SIZE = 3;
//		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
//		List<String> bridge = bridgeMaker.makeBridge(SIZE);
//		BridgeGame bridgeGame = new BridgeGame(bridge);
//		IntStream.range(0, SIZE)
//				.forEach(i -> bridgeGame.move());
//		Assertions.assertThat(bridgeGame.gameEnd()).isEquals(true);
//	}
}
