package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void update_size_sendDto_기능테스트() {
        Result result = new Result();
        result.update(true);
        result.update(false);
        assertThat(result.size())
                .isEqualTo(2);
        assertThat(result.sendDto().result)
                .isEqualTo(Arrays.asList(true,false));
    }

}
