package bridge.model;

import bridge.type.SlabType;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SlabsTest {
    @Test
    void DB_인스턴스_가져오기() {
        assertThat(Slabs.getInstance()).isInstanceOf(Slabs.class);
    }

    @Test
    void DB_모두_넣기() {
        Slabs slabs = Slabs.getInstance();
        List<SlabDTO> dto = this.slabs();

        assertThat(slabs.insertAll(dto)).isTrue();
    }

    @Test
    void DB_모두_가져오기() {
        Slabs slabs = Slabs.getInstance();
        List<SlabDTO> dto = this.slabs();
        slabs.insertAll(dto);

        assertThat(slabs.getAll()).isEqualTo(dto);
    }

    List<SlabDTO> slabs() {
        return List.of(
                new SlabDTO(0, SlabType.DOWN, true),
                new SlabDTO(0, SlabType.UP, false),
                new SlabDTO(1, SlabType.UP, true),
                new SlabDTO(1, SlabType.DOWN, false),
                new SlabDTO(2, SlabType.DOWN, true),
                new SlabDTO(2, SlabType.UP, false)
        );
    }
}