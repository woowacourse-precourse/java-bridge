package bridge.domain.command;

import static org.junit.jupiter.api.Assertions.*;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeRestartCommandTest {


	@DisplayName("R or Q가 입력됬을때 리턴값 테스트")
	@ParameterizedTest
	@CsvSource(value = {"R:0","Q:2147483647"},delimiterString = ":")
	void R과Q가입력됬을때_0과_인트맥스값이출력됩니다(String input, int expected) {
		Assertions.assertThat(BridgeRestartCommand.getRestartCode(input)).isEqualTo(expected);
	}
}