package bridge.domain.rule;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeRuleTest {

	@DisplayName("다리길이 3~20사이 통과 test")
	@ParameterizedTest
	@ValueSource(ints = {3, 15, 20, 18, 5})
	void 다리길이_통과_테스트(int input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatCode(() -> bridgeRule.isInRange(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("다리길이 3~20사이 예외 test")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 21, 100, 1000})
	void 다리길이_예외_테스트(int input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatIllegalArgumentException()
				.isThrownBy(() -> bridgeRule.isInRange(input))
				.withMessageContaining("[ERROR]");
	}


	@DisplayName("다리길이 숫자 여부 통과 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "100", "55"})
	void 다리길이는_숫자여야합니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatCode(() -> bridgeRule.isNumber(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("다리길이 숫자 여부 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {" ", "E", "##", "%%", " A "})
	void 다리길이에_숫자가아닌값이오면_예외가발생합니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatIllegalArgumentException()
				.isThrownBy(() -> bridgeRule.isNumber(input))
				.withMessageContaining("[ERROR]");
	}

	@DisplayName("재시작 명령어 통과 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"R", "Q"})
	void 재시작명령어는_R_Q_만가능합니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatCode(() -> bridgeRule.isRetryCommand(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("재시작 명령어 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "ㅁ"})
	void 재시작명령어는_R_Q이외에_입력되면안됩니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatIllegalArgumentException()
				.isThrownBy(() -> bridgeRule.isRetryCommand(input))
				.withMessageContaining("[ERROR]");
	}

	@DisplayName("이동 명령어 통과 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"U", "D"})
	void 이동명령어는_U_D_만가능합니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatCode(() -> bridgeRule.isMoveCommand(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("재시작 명령어 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "ㅁ"})
	void 이동명령어는_U_D_이외에_입력되면안됩니다(String input) {
		BridgeRule bridgeRule = new BridgeRule();
		assertThatIllegalArgumentException()
				.isThrownBy(() -> bridgeRule.isMoveCommand(input))
				.withMessageContaining("[ERROR]");
	}
}