package bridge;

import bridge.domain.BridgeGame;
import bridge.enums.UpDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class GameTest {
	private final int BRIDGE_SIZE = 3;
	private BridgeMaker bridgeMaker;
	private List<String> bridge;
	private BridgeGame bridgeGame;

	class BridgeOnlyZeroGenerator implements BridgeNumberGenerator {
		@Override
		public int generate() {
			return 0;
		}
	}

	@BeforeEach
	void beforeEach(){
		bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
		bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
		bridgeGame = new BridgeGame(bridge);
	}

	@DisplayName("게임 정상 테스트")
	@Test
	void normalTest(){
		IntStream.range(0, BRIDGE_SIZE)
				.forEach(i -> bridgeGame.move(UpDown.DOWN.getDirection()));
		Assertions.assertThat(bridgeGame.isGameWin()).isTrue();
	}

	@DisplayName("게임 예외 테스트")
	@Test
	void exceptionTest(){
		IntStream.range(0, BRIDGE_SIZE)
				.forEach(i -> bridgeGame.move(UpDown.UP.getDirection()));
		Assertions.assertThat(bridgeGame.isGameWin()).isFalse();
	}

	@DisplayName("다리를 못건너는 경우 종료 확인")
	@Test
	void crossWrongDirectionTest(){
		bridgeGame.move("D");
		bridgeGame.move("D");
		bridgeGame.move("U");
		Assertions.assertThat(bridgeGame.isGameLoss()).isTrue();
	}
}
