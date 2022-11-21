package bridge.controller;

import bridge.model.SlabDTO;
import bridge.model.Slabs;
import bridge.type.GlassType;
import bridge.type.PositionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveControllerTest {

    public MoveController controller;

    @Test
    void 슬래브_찾기() {
        SlabDTO slab = this.controller.findSlabBy(1, PositionType.DOWN);
        assertThat(slab).isEqualTo(this.initData().get(3));
    }

    @Test
    void 밟은_슬래브로_설정하기() {
        assertDoesNotThrow(() -> this.controller.updateTread(this.initData().get(0)));
        assertDoesNotThrow(() -> this.controller.updateTread(this.initData().get(2)));
    }

    @Test
    void 마지막_밟은_위치_불러오기() {
        this.controller.updateTread(this.initData().get(0));
        this.controller.updateTread(this.initData().get(2));

        int step = this.controller.getLastTreadStep();

        assertThat(step).isEqualTo(1);
    }

    @Test
    void 밟은_슬래브_데이터_가져오기() {
        this.controller.updateTread(this.initData().get(0));
        this.controller.updateTread(this.initData().get(2));

        List<List<String>> maps = this.controller.getSlapMaps(1);

        assertThat(maps.get(0)).containsExactly(" ", "O");
        assertThat(maps.get(1)).containsExactly("O", " ");
    }

    @BeforeEach
    public void 초기_데이터_삽입하기() {
        Slabs database = Slabs.newInstance();
        database.insertAll(this.initData());

        this.controller = new MoveController(database);
    }

    public List<SlabDTO> initData() {
        return List.of(
                new SlabDTO(0, PositionType.DOWN, GlassType.TEMPERED),
                new SlabDTO(0, PositionType.UP, GlassType.NORMAL),
                new SlabDTO(1, PositionType.UP, GlassType.TEMPERED),
                new SlabDTO(1, PositionType.DOWN, GlassType.NORMAL),
                new SlabDTO(2, PositionType.UP, GlassType.NORMAL),
                new SlabDTO(2, PositionType.DOWN, GlassType.TEMPERED)
        );
    }
}