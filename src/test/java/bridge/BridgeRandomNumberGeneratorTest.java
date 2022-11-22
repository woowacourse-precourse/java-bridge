package bridge;

import bridge.domain.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {
	@Test
	void 제대로_된_값_리턴(){
		for (int i = 0 ; i < 1000 ; i++){
			int number = new BridgeRandomNumberGenerator().generate();

			if (number != 0 && number != 1) {
				fail();
			}
		}
	}
}