package bridge.domain.movingrecord;

import bridge.domain.direction.Direction;
import bridge.domain.referee.Judgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class MovingRecordTest {

    private MovingRecord record;

    @BeforeEach
    void setUp() {
        this.record = new MovingRecord();
    }

    @DisplayName("write 메소드에 판정, 방향이 입력되었을 때 판정과 방향을 저장하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForWriteTest")
    void write_test(Judgement judgement, Direction direction, String inputJudgement, String inputDirection) {
        record.write(judgement, direction);

        assertThat(record.toString()).contains(inputJudgement, inputDirection);
    }

    @DisplayName("read 메소드를 호출하였을 때 판정과 방향에 대한 entrySet 스트림을 입력 순서대로 반환하는지 확인")
    @ParameterizedTest(name = "{index}")
    @MethodSource("provideArgumentsForMakingRecord")
    void read_test(List<Judgement> judgements, List<Direction> directions) {
        MovingRecord record = writeMultiple(judgements, directions);

        List<Direction> recordedDirections = record.read()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        assertThat(recordedDirections).isEqualTo(directions);
    }

    @DisplayName("size 메소드를 호출하였을 때 전체 자료의 길이를 반환하는지 확인")
    @ParameterizedTest(name = "{index}")
    @MethodSource("provideArgumentsForMakingRecord")
    void size_test(List<Judgement> judgements, List<Direction> directions) {
        int expectedSize = judgements.size();
        MovingRecord record = writeMultiple(judgements, directions);

        int actualSize = record.size();

        assertThat(actualSize).isEqualTo(expectedSize);
    }

    private MovingRecord writeMultiple(List<Judgement> judgements, List<Direction> directions) {
        for (int i = 0; i < judgements.size(); i++) {
            record.write(judgements.get(i), directions.get(i));
        }
        return record;
    }

    static Stream<Arguments> provideArgumentsForWriteTest() {
        return Stream.of(
                Arguments.of(new Judgement(true), new Direction("U"), "true", "\"U\""),
                Arguments.of(new Judgement(true), new Direction("D"), "true", "\"D\""),
                Arguments.of(new Judgement(false), new Direction("U"), "false", "\"U\""),
                Arguments.of(new Judgement(false), new Direction("D"), "false", "\"D\"")
        );
    }

    static Stream<Arguments> provideArgumentsForMakingRecord() {
        return Stream.of(
                Arguments.of(List.of(new Judgement(true),
                                new Judgement(true),
                                new Judgement(false),
                                new Judgement(false),
                                new Judgement(false)),
                        List.of(new Direction("U"),
                                new Direction("D"),
                                new Direction("U"),
                                new Direction("U"),
                                new Direction("D"))),
                Arguments.of(List.of(new Judgement(false),
                                new Judgement(true),
                                new Judgement(false)),
                        List.of(new Direction("U"),
                                new Direction("U"),
                                new Direction("D"))),
                Arguments.of(List.of(new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true),
                                new Judgement(true)),
                        List.of(new Direction("D"),
                                new Direction("U"),
                                new Direction("D"),
                                new Direction("U"),
                                new Direction("U"),
                                new Direction("D")))
        );
    }
}