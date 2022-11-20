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

	@Test
	public void 플레이어_이동_테스트() {
	    //given
		Player player = new Player();
		int currentLocation = player.getCurrentLocation();
	    //when
		player.move();
		int moveLocation = player.getCurrentLocation();
	    //then
		assertThat(currentLocation).isNotEqualTo(moveLocation);
	}
}
