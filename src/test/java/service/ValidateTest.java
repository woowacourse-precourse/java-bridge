package service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Validate;

public class ValidateTest {
	Validate validate = new Validate();

	// 다리 크기 입력 예외 오류 테스트
	@DisplayName("다리 크기가 3보다 작으면 예외 발생")
	@Test
	void inputBySmallerSize() {
		assertThrows(RuntimeException.class, () -> validate.validateSize("2"));
	}
	
	@DisplayName("다리 크기가 20보다 크면 예외 발생")
	@Test
	void inputByBiggerSize() {
		assertThrows(RuntimeException.class, () -> validate.validateSize("21"));
	}
	
	@DisplayName("숫자가 아닌  문자가 입력 될 경우 예외 발생")
	@Test
	void inputByWrongSize() {
		assertThrows(RuntimeException.class, () -> validate.validateSize("a"));
	}
	
	// 게임 이동 입력 예외 오류 테스트
	@DisplayName("U, D 외 다른 문자가 입력 될 경우 예외 발생")
	@Test
	void inputByWrongMoving() {
		assertThrows(RuntimeException.class, () -> validate.validateGameCommand("A"));
	}
	
	@DisplayName("문자열이 입력 될 경우 예외 발생")
	@Test
	void inputByStringMoving() {
		assertThrows(RuntimeException.class, () -> validate.validateGameCommand("abc"));
	}
	
	// 게임 재시작 여부 입력 예외 오류 테스트
	@DisplayName("R, Q 외 다른 문자가 입력 될 경우 예외 발생")
	@Test
	void inputByWrongCommand() {
		assertThrows(RuntimeException.class, () -> validate.validateGameCommand("B"));
	}
	
	@DisplayName("문자열이 입력 될 경우 예외 발생")
	@Test
	void inputByStringCommand() {
		assertThrows(RuntimeException.class, () -> validate.validateGameCommand("123"));
	}
}