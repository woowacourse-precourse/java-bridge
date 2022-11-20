package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void 플레이어_상태_테스트() {
		//given
		Player player = new Player();
		assertThat(player.isAlive()).isTrue();
		//when
		player.die();
		//then
		assertThat(player.isDead()).isTrue();
	}
}
