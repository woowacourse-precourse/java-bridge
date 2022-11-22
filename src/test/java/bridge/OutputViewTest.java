package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
	OutputView test = new OutputView();

	@DisplayName("입력한 현재좌표 ArrayList 에 대해 단계적으로 bridgeShape 모양이 출력되는지")
	@Test
	void verifyBridgeShape() {
		ArrayList<String> currentCoordinate = newArrayList("U", "D", "U");
		test.printMap(0, currentCoordinate);
		assertThat(test.mapU).isEqualTo("[ O ");
		test.printMap(1, currentCoordinate);
		assertThat(test.mapU).isEqualTo("[ O |   ");
		test.printMap(2, currentCoordinate);
		assertThat(test.mapU).isEqualTo("[ O |   | O ");

	}
}
