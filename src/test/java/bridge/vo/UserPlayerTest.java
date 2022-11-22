package bridge.vo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserPlayerTest {
	@DisplayName("건널 수 있는 값인지 판단")
	@Test
	void isCrossStep() {
		// given
		UserPlayer userPlayer = new UserPlayer();
		userPlayer.setMovingDirection("D");
		userPlayer.setMovingDirection("U");
		userPlayer.setMovingDirection("D");
		//	when
		Bridge bridge = new Bridge(List.of("U", "D", "U"));
		// then
		assertThat(userPlayer.isCrossStep(bridge, 0)).isFalse();
	}

	@DisplayName("게임 다시 시도시 총 도전횟수 업데이트 확인 테스트")
	@Test
	void initUserPlayInformation() {
		// //given
		UserPlayer userPlayer = new UserPlayer();
		userPlayer.setMovingDirection("D");

		// //when
		userPlayer.initUserPlayInformation();

		// //then
		assertThat(userPlayer.getTotalAttempt()).isEqualTo(2);
	}
}
