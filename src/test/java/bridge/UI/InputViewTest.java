package bridge.UI;


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

        @Test
        void readBridgeSize_case1(){
            String input = "10";
            getBridgeSizeTest(input);
        }

        @Test
        void readBridgeSize_case2(){
            String input = "3";
            getBridgeSizeTest(input);
        }

        @Test
        void readBridgeSize_case3(){
            String input = "20";
            getBridgeSizeTest(input);
        }

        @Test
        void readBridgeSize_exceptionCase1(){
            String input = "1";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readBridgeSize_exceptionCase2(){
            String input = "100";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readBridgeSize_exceptionCase3(){
            String input = "-5";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readBridgeSize_exceptionCase4(){
            String input = "0";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readBridgeSize_exceptionCase5(){
            String input = "Hello World";
            getExceptionTest(input,functionSupply);
        }

        @Test
        void readBridgeSize_exceptionCase6(){
            String input = "!@#!$";
            getExceptionTest(input,functionSupply);
        }
    }
}