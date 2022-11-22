package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveResultTest {


	@DisplayName("사용자의 입력이 옳은 칸을 고른 경우를 구한다.")
	@Test
	void getNumberOfCorrect() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U","D","D","U"), List.of("U","D","D","D"));
		//when, then
		assertThat(moveResult.isCorrect()).isEqualTo(false);
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