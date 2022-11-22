package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @DisplayName("이전 게임의 다리 정보 리스트를 초기화 하는 기능 성공")
    @Test
    void getDirectionByRandomNumber() {
        int downNumber = 0;
        String result = Direction.findDirectionByNumber(downNumber).getMovingDirection();
        String expect = "D";

        assertThat(result).isEqualTo(expect);
    }
}
