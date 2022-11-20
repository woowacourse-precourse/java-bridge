package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

	private Bridge bridge;

	@BeforeEach()
	@DisplayName("다리 길이가 3인 다리 만들기")
	void init() {

		bridge = new Bridge(List.of("D", "U", "U"));
	}

	@ParameterizedTest
	@DisplayName("현재 다리의 한 부분과 일치한다 - 성공")
	@CsvSource({"0,D", "1,U", "2,U"})
	void checkSuccessMatching(int index, String movingCommand) {
		assertThat(bridge.match(index, Move.find(movingCommand))).isTrue();
	}

	@ParameterizedTest
	@DisplayName("다리 길이와 알맞지 않은 범위 인덱스를 입력할 경우 예외 처리된다 - 실패")
	@CsvSource({"-1,D", "4,U"})
	void checkMatchingFailureWhenNotRangeOfIndex(int index, String movingCommand) {
		assertThatThrownBy(
			() -> bridge.match(index, Move.find(movingCommand))
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("생성한 다리 길이와 다리 길이의 값을 돌려주는 메소드가 일치한다 - 성공")
	void length() {
		assertThat(bridge.length()).isEqualTo(3);
	}
}
