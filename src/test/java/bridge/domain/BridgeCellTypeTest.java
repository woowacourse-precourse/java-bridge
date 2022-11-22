package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeCellTypeTest {

    @Test
    @DisplayName("존재하는 cellType 는 GameCommand 타입으로 변환한다.")
    void validCellTypes() {
        // given
        List<String> validCellTypes = Arrays.stream(BridgeCellType.values())
            .map(BridgeCellType::getCellType)
            .collect(Collectors.toList());
        // then
        validCellTypes.forEach(
            type -> assertThat(BridgeCellType.values()).contains(BridgeCellType.of(type)));
    }

    @Test
    @DisplayName("존재하지 않는 cellType 를 변환하면 예외가 발생한다.")
    void invalidCellTypes() {
        // given
        List<String> invalidCellType = List.of("L", "R", "LEFT", "UP");

        // then
        invalidCellType.forEach(type -> assertThatThrownBy(() -> BridgeCellType.of(type)));

    }
}