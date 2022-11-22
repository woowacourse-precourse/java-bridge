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
	@CsvSource(value = {"R:true","Q:false"},delimiterString = ":")
	void R입력시_true_Q입력시_false_테스트(String input, boolean expected) {
		Assertions.assertThat(BridgeRestartCommand.isRetry(input)).isEqualTo(expected);
	}
}