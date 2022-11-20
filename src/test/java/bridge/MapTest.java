package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    @DisplayName("맵 생성이 잘 되는지 확인한다.")
    @Test
    void testMapInitialize() {
        Map map = new Map();

        assertThat(map.getMap()).containsExactly("[ ", "[ ");
    }

    @DisplayName("사용자의 경로에 따라 맵이 잘 그려지는지 확인한다.")
    @CsvSource(value = {"U:true:[   ],[ O ]", "D:true:[ O ],[   ]", "U:false:[   ],[ X ]", "D:false:[ X ],[   ]"}, delimiter = ':')
    @ParameterizedTest
    void testDrawMap(String command, boolean isCorrectPath, String path) {
        Map map = new Map();
        map.drawMap(command, isCorrectPath);

        assertThat(map.getMap()).containsExactly(path.split(","));
    }

}
