package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveResultTest {

	@DisplayName("모두 옳은 칸을 고른 다리의 상태를 정해진 형식대로 만든다.")
	@Test
	void renderSuccess() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U", "D", "D"));
		//when, then
		assertThat(moveResult.getMap()).isEqualTo("[ O |   |   ]\n[   | O | O ]");
	}

	@DisplayName("틀린 칸을 고른 다리의 상태를 정해진 형식대로 만든다.")
	@Test
	void renderFail() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U","D","D","D"));
		//when, then
		assertThat(moveResult.getMap()).isEqualTo("[ O |   |   |   ]\n[   | O | O | X ]");
	}
	@DisplayName("옳은 칸을 고른 횟수를 구한다.")
	@Test
	void getNumberOfCorrect() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U","D","D","D"));
		//when, then
		assertThat(moveResult.getNumberOfCorrect()).isEqualTo(3);
	}

	@DisplayName("성공하지 못한 경우 성공 여부를 구한다.")
	@Test
	void isSuccessNo() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U","D","D","D"));
		//when, then
		assertThat(moveResult.isSuccess()).isEqualTo(false);
	}

	@DisplayName("성공한 경우 성공 여부를 구한다.")
	@Test
	void isSuccessYes() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U","D","D","U"));
		//when, then
		assertThat(moveResult.isSuccess()).isEqualTo(true);
	}
}