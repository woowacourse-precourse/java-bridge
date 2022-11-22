package bridge;

import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class UnitTest {

	@DisplayName("다리 생성 정상 테스트")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
	void BridgeSizeTest(Integer input) {
		Assertions.assertThatCode(() -> {
			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
			bridgeMaker.makeBridge(input);
		}).doesNotThrowAnyException();
	}

	@DisplayName("다리 생성 예외 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 2, 21, 50, 100})
	void BridgeSizeExceptionTest(Integer input) {
		Assertions.assertThatThrownBy(() -> {
			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
			bridgeMaker.makeBridge(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void moveTest(){
		BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
//		bridgeGame.move();
//		Player player = new Player();
//		bridgeGame.move(player);
//		Assertions.assertThat(player.checkEnd(1)).isTrue();
	}
}
