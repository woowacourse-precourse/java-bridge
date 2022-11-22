package bridge.domain;

import bridge.domain.type.MoveResultType;
import bridge.domain.type.BridgeLineType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveRecordTest {
    MoveRecord moveRecord;
    MoveResultType moveResultType;
    String moveCommand;

    static Stream<Arguments> getResourceForRecord() {
        return Stream.of(
                Arguments.of(List.of(MoveResultType.SUCCESS), List.of("U"), "[ O ]\n[   ]"),
                Arguments.of(List.of(MoveResultType.FAIL), List.of("D"), "[   ]\n[ X ]"),
                Arguments.of(
                        List.of(MoveResultType.SUCCESS, MoveResultType.SUCCESS, MoveResultType.FAIL),
                        List.of("U", "D", "U"),
                        "[ O |   | X ]\n[   | O |   ]"
                )
        );
    }

    @BeforeEach
    void set() {
        moveRecord = new MoveRecord();
        moveResultType = MoveResultType.SUCCESS;
        moveCommand = BridgeLineType.UP.getCommand();
    }

    @ParameterizedTest
    @MethodSource("getResourceForRecord")
    @DisplayName("")
    void TestRecord(List<MoveResultType> moveResultTypes, List<String> moveCommands, String record) {
        for (int count = 0; count < moveResultTypes.size(); count++) {
            moveRecord.recordMovement(moveResultTypes.get(count), moveCommands.get(count));
        }
        assertThat(moveRecord.getRecord()).isEqualTo(record);
    }

    @Test
    void TestResetRecord() {
        moveRecord.recordMovement(moveResultType, moveCommand);
        moveRecord.resetRecord();
        assertThat(moveRecord.getRecord()).isEqualTo("[  ]\n[  ]");
    }
}
