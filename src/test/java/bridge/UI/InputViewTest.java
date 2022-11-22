package bridge.UI;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    OutputStream out;
    InputStream in;
    InputView inputView = new InputView();

    void beforeSetting(String input){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void getExceptionTest(String input, Supplier<?> testFunction){
        beforeSetting(input);
        try{
            testFunction.get();
        }catch(NoSuchElementException ignored){}
        assertThat(out.toString().trim()).contains(ERROR_MESSAGE);
    }

    @Nested
    class ReadBridgeSizeTest{

        Supplier<Integer> functionSupply = () -> inputView.readBridgeSize();

        void getBridgeSizeTest(String input){
            beforeSetting(input);
            int output = Integer.parseInt(input);
            assertThat(inputView.readBridgeSize()).isEqualTo(output);
        }

        @DisplayName("10을 넣었을 때, 정상적으로 다리 크기 return")
        @Test
        void readBridgeSize_case1(){
            String input = "10";
            getBridgeSizeTest(input);
        }

        @DisplayName("3을 넣었을 때, 정상적으로 다리 크기 return")
        @Test
        void readBridgeSize_case2(){
            String input = "3";
            getBridgeSizeTest(input);
        }

        @DisplayName("20을 넣었을 때, 정상적으로 다리 크기 return")
        @Test
        void readBridgeSize_case3(){
            String input = "20";
            getBridgeSizeTest(input);
        }

        @DisplayName("1을 넣었을 때, 3 이상 20 이하가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase1(){
            String input = "1";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("100을 넣었을 때, 3 이상 20 이하가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase2(){
            String input = "100";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("-5(음수)를 넣었을 때, 3 이상 20 이하가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase3(){
            String input = "-5";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("0을 넣었을 때, 3 이상 20 이하가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase4(){
            String input = "0";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("문자열을 넣었을 때, 정수가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase5(){
            String input = "Hello World";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("특수문자 문자열을 넣었을 때, 정수가 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase6(){
            String input = "!@#!$";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("빈칸을 넣었을 때, 정수를 입력한 것이 아니므로 에러 메세지와 함께 exception 발생.")
        @Test
        void readBridgeSize_exceptionCase7(){
            String input = " ";
            getExceptionTest(input,functionSupply);
        }
    }

    @Nested
    class ReadMovingTest{

        Supplier<String> functionSupply = () -> inputView.readMoving();

        void getReadMovingTest(String input){
            beforeSetting(input);
            assertThat(inputView.readMoving()).isEqualTo(input);
        }

        @DisplayName("readMoving 에서 U를 입력받았을 때, 다시 정상적으로 U를 return")
        @Test
        void readMoving_case1(){
            String input = "U";
            getReadMovingTest(input);
        }

        @DisplayName("readMoving 에서 D를 입력받았을 때, 다시 정상적으로 D를 return")
        @Test
        void readMoving_case2(){
            String input = "D";
            getReadMovingTest(input);
        }

        @DisplayName("readMoving 에서 UD를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase1(){
            String input = "UD";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 -1 를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase2(){
            String input = "-1";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 10000 를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase3(){
            String input = "10000";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 A를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase4(){
            String input = "A";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 Z를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase5(){
            String input = "Z";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 Hello 를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase6(){
            String input = "Hello";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 !!! 를 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase7(){
            String input = "!!!";
            getExceptionTest(input,functionSupply);
        }

        @DisplayName("readMoving 에서 그냥 빈칸을을 입력받았을 때, U나 D가 아니므로 에러 메세지와 함께 IllegalArgumentException 발생")
        @Test
        void readMoving_exceptionCase8(){
            String input = " ";
            getExceptionTest(input,functionSupply);
        }
    }

    @Nested
    class ReadGameCommandTest{

        Supplier<String> functionSupply = () -> inputView.readGameCommand();

        void getGameCommandTest(String input){
            beforeSetting(input);
            assertThat(inputView.readGameCommand()).isEqualTo(input);
        }

        @Test
        void readGameCommand_case1(){
            String input = "R";
            getGameCommandTest(input);
        }

        @Test
        void readGameCommand_case2(){
            String input = "Q";
            getGameCommandTest(input);
        }

        @Test
        void readGameCommand_exceptionCase1(){
            String input = "RQ";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase2(){
            String input = "A";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase3(){
            String input = "X";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase4(){
            String input = "Hi";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase5(){
            String input = " ";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase6(){
            String input = "!@#";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase7(){
            String input = "5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readGameCommand_exceptionCase8(){
            String input = "-1234";
            getExceptionTest(input,functionSupply);
        }
    }
}