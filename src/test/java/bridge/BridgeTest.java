package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    Bridge tsetBridge;

    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputIsNotNumber() {
        tsetBridge = new Bridge(5);
        System.out.println("다리 길이 : "+tsetBridge.getBrideState().size());
        System.out.print("다리 상태 : ");
        for(String state : tsetBridge.getBrideState())
            System.out.print(state+" ");
    }
}
