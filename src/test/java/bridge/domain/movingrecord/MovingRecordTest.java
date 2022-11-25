package bridge.domain.movingrecord;

import bridge.domain.direction.Direction;
import bridge.domain.referee.Judgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MovingRecordTest {

    private MovingRecord record;

    @BeforeEach
    void setUp() {
        Map<Judgement, Direction> records = new LinkedHashMap<>();
        records.put(new Judgement(true), new Direction("U"));
        records.put(new Judgement(true), new Direction("U"));
        records.put(new Judgement(true), new Direction("D"));
        records.put(new Judgement(true), new Direction("D"));
        records.put(new Judgement(false), new Direction("D"));
        this.record = new MovingRecord(records);
    }

    @DisplayName("makeBridgeSketches 메소드에 다리의 방향이 입력되었을 때 해당하는 다리의 판정과 방향을 1, 0, -1로 구분한 리스트를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForSketchesTest")
    void makeBridgeSketches_test(Direction direction, List<Integer> expectedSketches) {
        List<Integer> bridgeSketches = record.makeBridgeSketches(direction);

        assertThat(bridgeSketches).isEqualTo(expectedSketches);
    }

    static Stream<Arguments> provideArgumentsForSketchesTest() {
        return Stream.of(Arguments.of(new Direction("U"), List.of(1, 1, -1, -1, -1)),
                Arguments.of(new Direction("D"), List.of(-1, -1, 1, 1, 0)));
    }
}