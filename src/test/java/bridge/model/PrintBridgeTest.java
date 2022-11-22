package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PrintBridgeTest {

    @Test
    void 출력용_upShape_생성_출력_형식에_맞게_생성() {
        PrintBridge printBridge = new PrintBridge();
        List<String> playerBridgeUpShape = List.of(" O ", "   ", " O ");
        String printUpShape = printBridge.generatePrintUpShape(playerBridgeUpShape);
        String expectedPrintUpShape = "[ O |   | O ]";

        assertThat(printUpShape).isEqualTo(expectedPrintUpShape);
    }

    @Test
    void 출력용_downShape_생성_출력_형식에_맞게_생성() {
        PrintBridge printBridge = new PrintBridge();
        List<String> playerBridgeDownShape = List.of("   ", " O ", "   ");
        String printDownShape = printBridge.generatePrintDownShape(playerBridgeDownShape);
        String expectedPrintDownShape = "[   | O |   ]";

        assertThat(printDownShape).isEqualTo(expectedPrintDownShape);
    }
}