package bridge.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    private Bridge bridge;
    private List<String> path;

    @BeforeEach
    void setUp() {
        path = List.of("U", "D", "D", "U");
        bridge = new Bridge(path);
    }

    @Test
    @DisplayName("방향에 따라 접근 가능한 인덱스를 모두 반환한다.")
    void isReturnAllAccessibleIndexesWhenGivenDirection() {
        //given
        String direction = "U";

        //when
        List<Integer> result = bridge.getAccessibleIndexes(direction);

        //then
        assertThat(result).isEqualTo(List.of(0, 3));
    }

    @Test
    @DisplayName("알맞은 도착 지점을 반환한다.")
    void isReturnRightDestinationIndex() {
        //given
        int compareResult = path.size() - 1;

        //when
        int result = bridge.getDestinationIndex();

        //then
        assertThat(result).isEqualTo(compareResult);
    }
}
