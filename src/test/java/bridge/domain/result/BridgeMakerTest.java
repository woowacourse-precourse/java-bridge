package bridge.domain.result;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {


	@DisplayName("다리만들기 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:3","6:6"},delimiterString = ":")
	void 입력값size에맞는_다리길이가_나와야합니다(int size,int expected) {
		BridgeMaker bridgeMaker =new BridgeMaker(new BridgeRandomNumberGenerator());
		Assertions.assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(expected);
	}
}