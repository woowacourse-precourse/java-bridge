package bridge.domain;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

	@Test
	@DisplayName("플레이어를 이동시킨면 위치가 변한다.")
	void 플레이어_이동_테스트() {
		//given
		List<String> bridgeInput = Arrays.asList(UP, DOWN, UP);
		BridgeGame bridgeGame = new BridgeGame(bridgeInput);
		//when
		Player player = bridgeGame.getPlayer();
		int currentLocation = player.getCurrentLocation();
		System.out.println(currentLocation);
		bridgeGame.move(UP);
		int nextLocation = currentLocation + 1;
		//then
		Assertions.assertThat(bridgeGame.getPlayer().getCurrentLocation())
			.isEqualTo(nextLocation);
	}
}
