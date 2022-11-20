package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	@DisplayName("플레이어의 죽음을 나타내는 상태 테스트")
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
	@DisplayName("플레이어 이동 후 위치 변화 테스트")
	void 플레이어_이동_테스트() {
	    //given
		Player player = new Player();
		int currentLocation = player.getCurrentLocation();
	    //when
		player.move();
		int moveLocation = player.getCurrentLocation();
	    //then
		assertThat(currentLocation).isNotEqualTo(moveLocation);
	}

	@Test
	@DisplayName("플레이어가 죽었을 때 이동하는 예외처리 테스트")
	void 플레이어_사망_이동_테스트() {
		//given
		Player player = new Player();
		//when
		player.die();
		//then
		Assertions.assertThatThrownBy(player::move)
			.isInstanceOf(IllegalStateException.class);
	}
}
