package bridge.type;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LangTypeTest {

    @Test
    void 문자열_변환() {
        assertThat(LangType.HELLO_WORLD.toString()).isEqualTo("안녕 세계 %s");
    }

    @Test
    void format() {
        assertThat(LangType.format(LangType.HELLO_WORLD, "안녕")).isEqualTo("안녕 세계 안녕");
    }

    @Test
    void get() {
        assertThat(LangType.get(LangType.HELLO_WORLD)).isEqualTo("안녕 세계 %s");
    }
}