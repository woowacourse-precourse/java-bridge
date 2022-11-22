package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest{


    @Test
    @DisplayName("다리 길이 입력시 숫자가 아닌 경우 예외처리")
    void validateNoneNumber() {
        String size= "a";
        System.setIn(new ByteArrayInputStream(size.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            new InputView().readBridgeSize();
        }catch (Exception e){
            assertThat(out.toString()).contains("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    @Test
    @DisplayName("다리 길이 범위에 벗어난 경우 예외처리")
    void validateRange() {
        String size= "2";
        System.setIn(new ByteArrayInputStream(size.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            new InputView().readBridgeSize();
        }catch (Exception e){
            assertThat(out.toString()).contains("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

    }

    @Test
    @DisplayName("U 또는 D가 아닐 경우 예외처리")
    void validateMoving() {
        String size= "a";
        System.setIn(new ByteArrayInputStream(size.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            new InputView().readMoving();
        }catch (Exception e){
            assertThat(out.toString()).contains("[ERROR] U 또는 D를 입력해주세요.");
        }
    }

    @Test
    @DisplayName("R 또는 Q가 아닐 경우 예외처리")
    void validateCommand() {
        String size= "a";
        System.setIn(new ByteArrayInputStream(size.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            new InputView().readGameCommand();
        }catch (Exception e){
            assertThat(out.toString()).contains("[ERROR] R 또는 Q를 입력해주세요.");
        }
    }


}