package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapGeneratorTest {
    private Result result;

    @BeforeEach
    public void setUp() {
        result = new Result(0);
        /*
         * 테스트 결과 firstRow: [ResultType.SUCCESS] secondRow: [ResultType.EMPTY]
         */
        result.appendResult(ResultType.SUCCESS, Direction.UP);
    }

    @DisplayName("다리 생성 테스트")
    @Test
    public void generateLineTest() {
        MapGenerator mapGenerator = new MapGenerator();
        List<String> testMap = List.of("[ O ]", "[   ]");
        assertThat(mapGenerator.generateMap(result)).isEqualTo(testMap);
    }
}
