package bridge.View;

import org.junit.jupiter.api.Test;

import static bridge.AssertInput.assertInputByMockingTest;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    void 다리길이입력_테스트() {

        // 파라미터 테스트 적용 예정
        assertInputByMockingTest(()->{
                assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },")");

        assertInputByMockingTest(()->{
            assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },"ㅁ");

        assertInputByMockingTest(()->{
            assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },"a");

        assertInputByMockingTest(()->{
            assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },"2");

        assertInputByMockingTest(()->{
            assertThrows(IllegalArgumentException.class,()->inputView.readBridgeSize());
        },"21");

        assertInputByMockingTest(()->{
            assertDoesNotThrow(()->inputView.readBridgeSize());
        },"4");

    }
}