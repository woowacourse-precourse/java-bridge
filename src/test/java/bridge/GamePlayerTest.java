package bridge;

import bridge.mock.MockNumberGeneratorDependencyContainerImpl;
import bridge.user.GamePlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<Integer> bridgeNumbers = new ArrayList<>(Arrays.asList(1, 0, 1));
    private GamePlayer gamePlayer = new GamePlayer(new MockNumberGeneratorDependencyContainerImpl(bridgeNumbers));

    private final List<String> resultOutput = List.of("다리 건너기 게임을 시작합니다.",
            "다리의 길이를 입력해주세요.", "이동할 칸을 선택해주세요. (위: U, 아래: D)",
            "[ O ]",
            "[   ]",
            "이동할 칸을 선택해주세요. (위: U, 아래: D",
            "[ O |   ]",
            "[   | O ]",
            "이동할 칸을 선택해주세요. (위: U, 아래: D)",
            "[ O |   | O ]",
            "[   | O |   ]",
            "최종 게임 결과",
            "[ O |   | O ]",
            "[   | O |   ]",
            "게임 성공 여부: 성공",
            "총 시도한 횟수: 1");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("재시도 없이 한번에 다리 건너기에 성공한다.")
    @Test
    void 재시도_없이_게임_진행_전체_단계_테스트() {
        String userInputs = "3\nU\nD\nU";
        initInputStream(userInputs);

        gamePlayer.playGame();

        String s = outContent.toString();

        Assertions.assertThat(s).contains(resultOutput);
    }

    void initInputStream(String userInputs) {
        InputStream in = new ByteArrayInputStream(userInputs.getBytes());
        System.setIn(in);
    }


}
