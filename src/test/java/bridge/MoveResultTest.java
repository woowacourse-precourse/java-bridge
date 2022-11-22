package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveResultTest {
	@DisplayName("사용자의 입력이 옳은 칸을 고른 경우를 구한다.")
	@Test
	void isCorrectYes() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U", "D", "D", "U"), List.of("U", "D", "D", "U"));
		//when, then
		assertTrue(moveResult.isCorrect());
	}

	@DisplayName("사용자의 입력이 틀린 칸을 고른 경우를 구한다.")
	@Test
	void isCorrectNo() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U", "D", "D", "U"), List.of("U", "D", "D", "D"));
		//when, then
		assertFalse(moveResult.isCorrect());
	}

	@DisplayName("성공하지 못한 경우 성공 여부를 구한다.")
	@Test
	void isSuccessNo() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U", "D", "D", "U"), List.of("U", "D", "D", "D"));
		//when, then
		assertFalse(moveResult.isSuccess());
	}

	@DisplayName("성공한 경우 성공 여부를 구한다.")
	@Test
	void isSuccessYes() {
		//given
		MoveResult moveResult = new MoveResult(List.of("U", "D", "D", "U"), List.of("U", "D", "D", "U"));
		//when, then
		assertTrue(moveResult.isSuccess());
	}
}