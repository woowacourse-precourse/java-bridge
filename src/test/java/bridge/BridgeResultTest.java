package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class BridgeResultTest {

    @Test
    void 결과_출력_OX_게임결과() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        List<String> upBridge = new ArrayList<String>(List.of("O"," "));
        List<String> downBridge = new ArrayList<String>(List.of(" ","X"));
        outputView.printMap(upBridge,downBridge);

        assertEquals("[ O |   ]\r\n[   | X ]\r\n",out.toString());
    }
    @Test
    void 결과_출력_OOO_게임결과() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        List<String> upBridge = new ArrayList<String>(List.of("O"," ","O"));
        List<String> downBridge = new ArrayList<String>(List.of(" ","O"," "));
        outputView.printMap(upBridge,downBridge);

        assertEquals("[ O |   | O ]\r\n[   | O |   ]\r\n",out.toString());
    }
    @Test
    void 결과_출력_성공여부_시도횟수_성공() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        outputView.printResult(false,3);

        assertEquals("\n게임 성공 여부: 성공\r\n총 시도한 횟수: 3\r\n",out.toString());
    }

    @Test
    void 결과_출력_성공여부_시도횟수_실패() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        outputView.printResult(true,10);

        assertEquals("\n게임 성공 여부: 실패\r\n총 시도한 횟수: 10\r\n",out.toString());
    }
}
