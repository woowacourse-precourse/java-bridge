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
        List<SlabType> slabsValues = List.of(SlabType.DOWN, SlabType.DOWN, SlabType.UP);

        assertThat(slabs.insertAll(slabsValues)).isTrue();
    }

    @Test
    void DB_모두_가져오기() {
        Slabs slabs = Slabs.getInstance();
        List<SlabType> slabsValues = List.of(SlabType.DOWN, SlabType.DOWN, SlabType.UP);
        slabs.insertAll(slabsValues);

        assertThat(slabs.getAll()).isEqualTo(slabsValues);
    }
}