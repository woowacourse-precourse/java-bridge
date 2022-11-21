package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShownMapTest {

    private ShownMap shownMap;

    @BeforeEach
    void setUp() {
        shownMap = new ShownMap();
    }

    @DisplayName("맵의 요소 추가가 제대로 작동하는지 확인")
    @Test
    void checkAddingElement() {
        shownMap.addUpper('O');
        shownMap.addUpper('X');
        shownMap.addLower(' ');
        shownMap.addLower(' ');

        assertThat(shownMap.getShownMap())
                .isEqualTo(List.of(
                        List.of('O', 'X'),
                        List.of(' ', ' '))
                );
    }

    @DisplayName("맵의 초기화가 작동하는지 확인")
    @Test
    void checkClear() {
        shownMap.addUpper('O');
        shownMap.addLower(' ');
        shownMap.clear();

        assertThat(shownMap.getShownMap())
                .isEqualTo(List.of(
                        List.of(),
                        List.of())
                );
    }
}
