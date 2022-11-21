package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingStackTest {

	@DisplayName("사용자 이동 모음에 이동을 더한다.")
	@Test
	void addMoving() {
		//given
		MovingStack movingStack = new MovingStack();
		//when
		movingStack.addMoving(true);
		movingStack.addMoving(false);
		movingStack.addMoving(true);
		//then
		assertThat(movingStack.getMovingStack()).isEqualTo(List.of("U", "D", "U"));
	}

	@DisplayName("총 이동 횟수를 구한다.")
	@Test
	void getMovingCount() {
		//given
		MovingStack movingStack = new MovingStack();
		//when
		movingStack.addMoving(true);
		movingStack.addMoving(false);
		//then
		assertThat(movingStack.getMovingCount()).isEqualTo(2);
	}
}