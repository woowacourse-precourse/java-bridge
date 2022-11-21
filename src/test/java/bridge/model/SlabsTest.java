package bridge.model;

import bridge.type.GlassType;
import bridge.type.PositionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SlabsTest {
    @Test
    void 인스턴스_로드() {
        assertThat(Slabs.getInstance()).isInstanceOf(Slabs.class);
    }

    @Test
    void 단일_삽입() {
        Slabs slabs = Slabs.getInstance();
        SlabDTO dto = new SlabDTO(0, PositionType.DOWN, GlassType.TEMPERED);

        assertThat(slabs.insert(dto)).isTrue();
    }

    @Test
    void 모두_삽입() {
        Slabs slabs = Slabs.getInstance();
        List<SlabDTO> dto = this.slabs();

        assertThat(slabs.insertAll(dto)).isTrue();
    }

    @Test
    void 모두_로드() {
        Slabs slabs = Slabs.getInstance();
        List<SlabDTO> dto = this.slabs();
        slabs.insertAll(dto);

        assertThat(slabs.getAll()).isEqualTo(dto);
    }

    List<SlabDTO> slabs() {
        return List.of(
                new SlabDTO(0, PositionType.DOWN, GlassType.TEMPERED),
                new SlabDTO(0, PositionType.UP, GlassType.NORMAL),
                new SlabDTO(1, PositionType.UP, GlassType.TEMPERED),
                new SlabDTO(1, PositionType.DOWN, GlassType.NORMAL),
                new SlabDTO(2, PositionType.DOWN, GlassType.TEMPERED),
                new SlabDTO(2, PositionType.UP, GlassType.NORMAL)
        );
    }
}