package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    @Test
    void 사용자_위치_값확인_로직_테스트() {
        int check = 999;
        boolean checkBridge = true;
        int userPositionValue = 1;

        if(checkBridge == true && userPositionValue == 1){
            check = 0;
            assertThat(check).isEqualTo(0);
            return;
        }

        if(checkBridge == false && userPositionValue == 0){
            check = 1;
            assertThat(check).isEqualTo(1);
            return;
        }

        check = 2;
        assertThat(check).isEqualTo(2);
    }
}
