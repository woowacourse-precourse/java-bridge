package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameSettingTest {
	@DisplayName("게임세팅테스트 : 게임 시작시") @Test public void settingTest1() {
		List<String> bridge = GameSetting.makeBridge(5);
		Assertions.assertThat(bridge).size().isEqualTo(5);
		Assertions.assertThat(bridge).containsAnyOf("U", "D");
	}
}
