package bridge.model;

import bridge.Env;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountersTest {

    @Test
    void 인스턴스_가져오기() {
        Counters getInstance = Counters.getInstance();
        assertThat(getInstance).isInstanceOf(Counters.class);

        Counters newInstance = Counters.newInstance();
        assertThat(newInstance).isInstanceOf(Counters.class);
    }

    @Test
    void 단일_삽입하기() {
        Counters database = Counters.newInstance();
        assertThat(database.insert(this.counterDTO)).isTrue();
    }

    @Test
    void 단일_가져오기() {
        Counters database = Counters.newInstance();
        database.insert(this.counterDTO);

        assertThat(database.get(0).getValue()).isEqualTo(0);
    }

    @Test
    void 데이터_업데이트하기() {
        Counters database = Counters.newInstance();
        database.insert(this.counterDTO);

        CounterDTO dto = database.get(0);
        dto.addValue(1);
        database.update(dto);

        assertThat(database.get(0).getValue()).isEqualTo(1);
    }

    private final CounterDTO counterDTO = new CounterDTO(Env.NAME_OF_TRIES_NUMBER, 0);
}