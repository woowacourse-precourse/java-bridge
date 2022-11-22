package bridge.domain;

import bridge.domain.user.Path;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PathTest {

    private Path path;

    @BeforeEach
    void setUp() {
        path = new Path();
    }

    @Test
    @DisplayName("이동 경로 추가 테스트")
    void addPathTest() {
        List<Boolean> isCorrects = List.of(true, false, true, false, true);

        for (Boolean isCorrect : isCorrects) {
            path.addPath(isCorrect);
        }

        Assertions.assertThat(path.toString()).isEqualTo("[ O | X | O | X | O ]\n");
        Assertions.assertThat(path).extracting("paths").extracting("size").isEqualTo(5);
    }

    @Test
    @DisplayName("이동 경로 초기화 테스트")
    void clearPathTest() {
        List<Boolean> isCorrects = List.of(true, false, true, false, true);

        for (Boolean isCorrect : isCorrects) {
            path.addPath(isCorrect);
        }

        path.clearPath();

        Assertions.assertThat(path.toString()).isEqualTo("[  ]\n");
        Assertions.assertThat(path).extracting("paths").extracting("size").isEqualTo(0);
    }

    @Test
    @DisplayName("빈 이동 경로 추가 테스트")
    void addEmptyPathTest() {

        for (int i = 0; i < 5; i++) {
            path.addEmptyPath();
        }

        Assertions.assertThat(path.toString()).isEqualTo("[   |   |   |   |   ]\n");
        Assertions.assertThat(path).extracting("paths").extracting("size").isEqualTo(5);
    }
}
