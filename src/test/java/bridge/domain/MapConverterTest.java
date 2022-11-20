package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapConverterTest {

    private MapConverter mapConverter;

    @BeforeEach
    void setUp() {
        mapConverter = new MapConverter();
    }

    @DisplayName("정상적으로 맵을 그리는지 확인")
    @Test
    void drawMapSuccess() {
        mapConverter.drawNext("U", true);
        mapConverter.drawNext("D", true);
        mapConverter.drawNext("U", false);

        assertThat(mapConverter.getUpperMap()).isEqualTo(List.of('O', ' ', 'X'));
        assertThat(mapConverter.getLowerMap()).isEqualTo(List.of(' ', 'O', ' '));
    }

    @DisplayName("정상적으로 맵을 초기화하는지 확인")
    @Test
    void initializeMapSuccess() {
        mapConverter.drawNext("D", true);
        mapConverter.drawNext("U", false);
        mapConverter.initialize();

        assertThat(mapConverter.getUpperMap()).hasSize(0);
        assertThat(mapConverter.getLowerMap()).hasSize(0);
    }
}
