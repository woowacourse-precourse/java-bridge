package bridge.view;

import bridge.domain.MovingMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {

    @DisplayName("MovingMap의 포매팅")
    @Nested
    class FormatMovingMapTest {

        @DisplayName("성공적으로 움직인 MovingMap")
        @Test
        void success() {
            OutputFormatter outputFormatter = new OutputFormatter();
            MovingMap movingMap = new MovingMap();

            movingMap.addMoving("U", true);
            movingMap.addMoving("U", true);
            movingMap.addMoving("U", true);

            String formattedString = outputFormatter.formatMovingMap(movingMap);

            Assertions.assertThat(formattedString).isEqualTo("[ O | O | O ]\n[   |   |   ]");
        }

        @DisplayName("실패로 움직인 MovingMap")
        @Test
        void fail() {
            OutputFormatter outputFormatter = new OutputFormatter();
            MovingMap movingMap = new MovingMap();

            movingMap.addMoving("U", true);
            movingMap.addMoving("D", false);

            String formattedString = outputFormatter.formatMovingMap(movingMap);

            Assertions.assertThat(formattedString).isEqualTo("[ O |   ]\n[   | X ]");
        }
    }
}