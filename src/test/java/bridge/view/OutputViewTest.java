package bridge.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    OutputView outputView;

    @BeforeEach
    void initView(){
        outputView = new OutputView();
    }

    @Test
    @DisplayName("게임이 시작될 때, 호출이 올바른지 테스트")
    void 시작_테스트(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printStart();
        assertThat(outputStream.toString()).contains("다리 건너기 게임을 시작합니다.");
    }

    @Test
    @DisplayName("게임이 종료될 때, 호출이 올바른지 테스트")
    void 결과_테스트1(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String result = "실패";
        outputView.printResult(result);
        assertThat(outputStream.toString()).contains("최종 게임 결과");
    }

    @Test
    @DisplayName("게임이 종료될 때, 호출이 올바른지 테스트")
    void 결과_테스트2(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String result = "실패";
        outputView.printResult(result);
        assertThat(outputStream.toString()).contains("게임 성공 여부:");
    }

    @Test
    @DisplayName("게임이 종료될 때, 호출이 올바른지 테스트")
    void 결과_테스트3(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String result = "성공";
        outputView.printResult(result);
        assertThat(outputStream.toString()).contains("총 시도한 횟수:");
    }



}