package bridge.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.RoundStatus;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MapAdapterTest {
    @Test
    void isReturnRightFormOfResultWhenGivenCourseAndRoundStatus() {
        //given
        List<String> course = List.of("U", "D");
        RoundStatus roundStatus = RoundStatus.FAIL;
        String compareResult = "[[ O |   ], [   | X ]]";

        //when
        String result = MapAdapter.changeMapToString(course, roundStatus).toString();

        //then
        assertThat(result).isEqualTo(compareResult);
    }


}
