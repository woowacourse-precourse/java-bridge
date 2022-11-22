package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
	BridgeNumberGenerator number = new BridgeRandomNumberGenerator();
	BridgeMaker test = new BridgeMaker(number);

	@DisplayName("makeBridge 가 인자로받은 size 와 일치하는 ArrayList 를 리턴하는지")
	@Test
	void makeBridgeOnInputSize() {
		System.out.println(test.makeBridge(5));
		assertThat(test.makeBridge(5).size()).isEqualTo(5);
	}

	@DisplayName("RandomNumber 클래스로 생성한 난수를 정상적으로 정해진 String 으로 변환하는지")
	@Test
	void verifyParseRandomNumber() {
		BridgeNumberGenerator parseTestNumber = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 0, 1));
		BridgeMaker parseTest = new BridgeMaker(parseTestNumber);
		assertThat(parseTest.makeBridge(5)).isEqualTo(newArrayList("U", "D", "U", "D", "U"));
	}
}
