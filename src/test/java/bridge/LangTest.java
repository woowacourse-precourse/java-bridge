package bridge;

import bridge.Lang;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LangTest {
    @Test
    void 문자열_변환() {
        assertThat(Lang.HELLO_WORLD.toString()).isEqualTo("안녕 세계 %s");
    }

    @Test
    void 문자열_포맷() {
        assertThat(Lang.format(Lang.HELLO_WORLD, "안녕")).isEqualTo("안녕 세계 안녕");
    }

    @Test
    void 문자열_로드() {
        assertThat(Lang.get(Lang.HELLO_WORLD)).isEqualTo("안녕 세계 %s");
    }
}