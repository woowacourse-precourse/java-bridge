package bridge.domain;

import bridge.enums.UpDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
	private BridgeGame bridgeGame;

	@BeforeEach
	void beforeEach(){
		bridgeGame = new BridgeGame(List.of("U", "D", "D"));
	}

	@DisplayName("움직인 방향대로 플레이어 움직임 배열에 추가된다.")
	@Test
	void moveTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(bridgeGame.getPlayerDirections())
				.containsOnly(UpDown.UP.getDirection(), UpDown.DOWN.getDirection());
	}

	@DisplayName("재시도시 가장 최근에 했던 움직임을 지워야 한다.")
	@Test
	void retryTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.retry();
		Assertions.assertThat(bridgeGame.getPlayerDirections())
				.containsOnly(UpDown.UP.getDirection());
	}

	@DisplayName("게임이 한 번만 진행되고 있으면 시도 횟수는 1번이다.")
	@Test
	void getTrialTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(bridgeGame.getTrial()).isEqualTo(1);
	}

	@DisplayName("한 번 재시도시 시도 횟수는 2번이다.")
	@Test
	void getTrialTwiceTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		bridgeGame.retry();
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(bridgeGame.getTrial()).isEqualTo(2);
	}
}