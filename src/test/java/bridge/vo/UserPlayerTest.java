package bridge.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserPlayerTest {
	@DisplayName("사용자 입력 테스트")
	@Test
	void inputMovingDirection() {
		//	given
		// UserPlayer userPlayer = UserPlayer.getInstance();
		// List<String> inputValue = List.of("D,D,U,D,U");

		//	when & then
		/*assertThat(userPlayer.setMovingDirection("F")).isEqualTo(false);
		assertThat(userPlayer.setMovingDirection("D")).isEqualTo(true);*/

	}

	@DisplayName("건널 수 있는 값인지 판단")
	@Test
	void isCrossableStep() {
		// //given
		// UserPlayer userPlayer = UserPlayer.getInstance();
		//
		// //when
		// userPlayer.setMovingDirection("U");
		//
		// //then
		// System.out.println("Record = " + userPlayer.showMoveRecord());
	}
}
