package bridge.domain.command;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMoveCommandTest {

	@DisplayName("랜덤값 0과1을 입력받았을때 알맞은 Column값이 나오는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:U", "0:D"}, delimiterString = ":")
	void 컬럼값_확인_테스트(int input, String expected) {
		String actual = BridgeMoveCommand.getBridgeColumn(input);
		Assertions.assertThat(actual).isEqualTo(expected);
	}
}