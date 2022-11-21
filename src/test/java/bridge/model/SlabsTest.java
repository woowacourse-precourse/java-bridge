package bridge.model;

import bridge.type.GlassType;
import bridge.type.PositionType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SlabsTest {

    @Test
    void 인스턴스_가져오기() {
        Slabs getInstance = Slabs.getInstance();
        assertThat(getInstance).isInstanceOf(Slabs.class);

        Slabs newInstance = Slabs.newInstance();
        assertThat(newInstance).isInstanceOf(Slabs.class);
    }


    @Test
    void 단일_삽입하기() {
        Slabs database = Slabs.newInstance();
        SlabDTO dto = new SlabDTO(0, PositionType.DOWN, GlassType.TEMPERED);

        assertThat(database.insert(dto)).isTrue();
    }

    @Test
    void 모두_삽입하기() {
        Slabs database = Slabs.newInstance();
        List<SlabDTO> slabs = this.slabs();

        assertThat(database.insertAll(slabs)).isTrue();
    }

    @Test
    void 모두_가져오기() {
        Slabs database = Slabs.newInstance();
        List<SlabDTO> slabs = this.slabs();
        database.insertAll(slabs);

        assertThat(database.getAll()).isEqualTo(slabs);
    }

    @Test
    void 데이터_업데이트하기() {
        Slabs database = Slabs.newInstance();
        database.insert(new SlabDTO(0, PositionType.DOWN, GlassType.NORMAL));

        SlabDTO dto = database.get(0);
        dto.setTread(true);
        database.update(dto);

        assertThat(database.get(0).isTread()).isTrue();
    }

    @Test
    void 원소_크기_가져오기() {
        Slabs database = Slabs.newInstance();
        database.insertAll(this.slabs());

        assertThat(database.size()).isEqualTo(6);
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