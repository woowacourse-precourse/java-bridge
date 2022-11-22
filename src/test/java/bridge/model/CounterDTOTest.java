package bridge.model;

import bridge.Env;
import bridge.type.GlassType;
import bridge.type.PositionType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CounterDTOTest {
    public static CounterDTO dto;

    @Test
    void 카운터_이름_가져오기() {
        assertThat(dto.getName()).isEqualTo(Env.NAME_OF_TRIES_NUMBER);
    }

    @Test
    void 카운터_숫자_가져오기() {
        assertThat(dto.getValue()).isEqualTo(2);
    }

    @Test
    void 카운터_숫자_변경하기() {
        dto.addValue(2);
        assertThat(dto.getValue()).isEqualTo(4);
    }

    @BeforeAll
    public static void beforeAll() {
        dto = new CounterDTO(Env.NAME_OF_TRIES_NUMBER, 2);
    }
}