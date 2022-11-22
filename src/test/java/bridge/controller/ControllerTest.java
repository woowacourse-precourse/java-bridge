package bridge.controller;

import bridge.Env;
import bridge.model.CounterDTO;
import bridge.model.Counters;
import bridge.model.SlabDTO;
import bridge.model.Slabs;
import bridge.type.GlassType;
import bridge.type.PositionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    public Controller controller;

    @Test
    void 슬래브_찾기() {
        SlabDTO slab = this.controller.findSlabBy(1, PositionType.DOWN);
        assertThat(slab).isEqualTo(this.slabData().get(3));
    }

    @Test
    void 밟은_슬래브로_설정하기() {
        assertDoesNotThrow(() -> this.controller.updateTread(this.slabData().get(0)));
        assertDoesNotThrow(() -> this.controller.updateTread(this.slabData().get(2)));
    }

    @Test
    void 마지막_밟은_위치_불러오기() {
        this.controller.updateTread(this.slabData().get(0));
        this.controller.updateTread(this.slabData().get(2));

        int step = this.controller.getLastTreadStep();

        assertThat(step).isEqualTo(1);
    }

    @Test
    void 밟은_슬래브_데이터_가져오기() {
        this.controller.updateTread(this.slabData().get(0));
        this.controller.updateTread(this.slabData().get(2));

        List<List<String>> maps = this.controller.getSlapMaps(1);

        assertThat(maps.get(0)).containsExactly(" ", "O");
        assertThat(maps.get(1)).containsExactly("O", " ");
    }

    @Test
    void 게임_시도_횟수_가져오기() {
        assertThat(this.controller.getRetries()).isEqualTo(5);
    }

    @Test
    void 게임_시도_횟수_더하기() {
        this.controller.updateRetries();

        assertThat(this.controller.getRetries()).isEqualTo(6);
    }

    @BeforeEach
    public void 초기_데이터_삽입하기() {
        Slabs slabs = Slabs.newInstance();
        Counters counters = Counters.newInstance();
        slabs.insertAll(this.slabData());
        counters.insert(this.counterData);

        this.controller = new Controller(slabs, counters);
    }

    public List<SlabDTO> slabData() {
        return List.of(
                new SlabDTO(0, PositionType.DOWN, GlassType.TEMPERED),
                new SlabDTO(0, PositionType.UP, GlassType.NORMAL),
                new SlabDTO(1, PositionType.UP, GlassType.TEMPERED),
                new SlabDTO(1, PositionType.DOWN, GlassType.NORMAL),
                new SlabDTO(2, PositionType.UP, GlassType.NORMAL),
                new SlabDTO(2, PositionType.DOWN, GlassType.TEMPERED)
        );
    }

    public CounterDTO counterData = new CounterDTO(Env.NAME_OF_TRIES_NUMBER, 5);
}