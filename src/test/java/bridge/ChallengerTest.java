package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.Challenger;

public class ChallengerTest {

	@DisplayName("다리의모양과 움직임이 다를 경우")
	@Test
	void createDifferentMoving() {
		String shape = "D";
		String moving = "U";

		assertThat(new Challenger(new ArrayList<>(), new ArrayList<>())
				.changeMoving(shape, moving)).isEqualTo("W");
	}
	@DisplayName("다리의모양과 움직임이 같은 경우")
	@Test
	void createSameMoving() {
		String shape = "D";
		String moving = "D";

		assertThat(new Challenger(new ArrayList<>(), new ArrayList<>())
				.changeMoving(shape, moving)).isEqualTo("D");
	}
}
