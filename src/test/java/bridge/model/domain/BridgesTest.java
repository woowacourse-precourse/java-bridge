package bridge.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.model.constant.Error;
import bridge.model.validation.BridgeSize;

class BridgesTest {
	@DisplayName("의도된 대로 사용 시 생성된 리스트의 길이가 makeBridge 메서드에 입력된 사이즈와 같다")
	@Test
	void normalCaseTest() {
		for (int size = BridgeSize.MIN.getSize(); size < BridgeSize.MAX.getSize(); size++) {
			Bridges bridges = new Bridges();
			bridges.makeBridge(size);
			List<String> result = bridges.getBridges();

			Assertions.assertEquals(result.size(), size);
		}
	}

	@DisplayName("예외 사항 발생 시 정해진 메세지를 리턴한다.")
	@Nested
	class ExceptionCaseTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalStateException.class, () -> new Bridges().getBridges());
			Assertions.assertEquals(Error.ABSENCE.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalStateException.class, () -> {
				Bridges bridges = new Bridges();
				bridges.makeBridge(3);
				bridges.makeBridge(4);
			});
			Assertions.assertEquals(Error.EXISTENCE.getMessage(), exception.getMessage());
		}
	}
}
