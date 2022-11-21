package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private InputStream in;
    private OutputStream out;
    private PrintStream standardOut;

    @BeforeEach
    final void init() {
        in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        standardOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

    }


    @AfterEach
    final void printOutput() {
        System.setOut(standardOut);
        System.out.println(out.toString().trim());
    }

    String useMove(String input,String moveDir,int index){

        final BridgeGame bridgeGame = new BridgeGame();
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bridgeGame.bridge = new ArrayList<>(List.of("U", "D", "U"));
        return bridgeGame.move(index, moveDir);
    }


    //이동 입력값에 따라 적적한 결과가 반환되는지 테스트
    @DisplayName("사용자 이동 입력 결과에 따른 반환값 테스트")
    @Test
    void checkMoveReturnValue() {

        String result = useMove("R","U",0);

        assertThat(result).isEqualTo("C");
    }

    //이동 입력값에 따라 적절한 결과가 출력되는지 테스트
    @DisplayName("사용자 이동 입력 결과에 따른 출력값 테스트")
    @Test
    void checkMovePrintValue() {

        useMove("R","D",0);

        assertThat(out.toString()).contains(
            "다리의 길이를 입력해주세요.",
            "[ X ]",
            "[   ]"
        );
    }

    //게임을 재시작 할 때, outputView 필드를 제대로 초기화 하는지 테스트

    //게임을 끝낼때 성공, 실패 여부에 따른 결과를 잘 출력하는지 테스트


    //play메서드에서 2번째 턴 부터 ]대신 |로 잘 바꿔서 출력 되는지 테스트

    //play메서드에서 게임 결과에 따라 적절한 값이 반환되는지 테스트
}

