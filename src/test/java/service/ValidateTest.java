package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Validate;

public class ValidateTest {
	private Validate validate = new Validate();
	List<String> testList = new ArrayList<>();
	private IllegalArgumentException exception = null;
	private String errorMessage = null;

	@DisplayName("다리 크기 입력 예외 오류 발생 및 오류 메시지 테스트")
	@Test
	void inputByWrongSize() {
		testList = List.of("a", "ab", "2", "21", "123");
		
		for (String testItem : testList) {
			exception = assertThrows(IllegalArgumentException.class, () -> validate.validateSize(testItem));
			errorMessage = exception.getMessage();
			assertEquals("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.", errorMessage);
		}
	}
	
	@DisplayName("이동 입력 예외 오류 발생 및 오류 메시지 테스트")
	@Test
	void inputByWrongMove() {
		testList = List.of("u", "UU", "d", "DD", "a", "A", "1", "123");
		
		for (String testItem : testList) {
			exception = assertThrows(IllegalArgumentException.class, () -> validate.validateMove(testItem));
			errorMessage = exception.getMessage();
			assertEquals("[ERROR] 위로 이동은 'U', 아래로 이동은 'D'를 입력하여야 합니다.", errorMessage);
		}
	}
	
	@DisplayName("게임 재시작 여부 예외 오류 발생 및 오류 메시지 테스트")
	@Test
	void inputByWrongCommand() {
		testList = List.of("q", "QQ", "r", "RR", "b", "B", "3", "321");
		
		for (String testItem : testList) {
			exception = assertThrows(IllegalArgumentException.class, () -> validate.validateGameCommand(testItem));
			errorMessage = exception.getMessage();
			assertEquals("[ERROR] 재시작은 'R', 종료는 'Q'를 입력하여야 합니다.", errorMessage);
		}
	}
	
	
}