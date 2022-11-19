package bridge.vo;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserPlayerTest {
	@DisplayName("사용자 입력 테스트")
	@Test
	void inputMovingDirection() {
		//	given
		UserPlayer userPlayer = UserPlayer.getInstance();
		// List<String> inputValue = List.of("D,D,U,D,U");

		//	when & then
		assertThat(userPlayer.inputMovingDirection("F")).isEqualTo(false);
		assertThat(userPlayer.inputMovingDirection("D")).isEqualTo(true);

	}
}
