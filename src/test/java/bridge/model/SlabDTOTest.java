package bridge.model;

import bridge.type.SlabType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SlabDTOTest {
    public static SlabDTO dto;

    @Test
    void 슬래브의_위치_가져오기() {
        assertThat(dto.getStep()).isEqualTo(6);
    }

    @Test
    void 슬래브의_타입_가져오기() {
        assertThat(dto.getSlabType()).isEqualTo(SlabType.DOWN);
    }

    @Test
    void 슬래브_밟아도_안전한지_여부_가져오기() {
        assertThat(dto.isSafe()).isFalse();
    }

    @Test
    void 슬래브를_밟았는지_여부_가져오기() {
        assertThat(dto.isTread()).isFalse();
    }

    @Test
    void 슬래브를_밟았는지_여부_설정하기() {
        dto.setTread(true);
        assertThat(dto.isTread()).isTrue();
    }

    @BeforeAll
    public static void beforeAll() {
        dto = new SlabDTO(6, SlabType.DOWN, false);
    }
}