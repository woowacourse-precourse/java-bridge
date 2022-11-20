package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerBridgeTest {

    PlayerBridge playerBridge;

    @BeforeEach
    void generatePlayerBridge() {
        playerBridge = new PlayerBridge();
    }

    @Test
    void 위_칸으로_이동_가능할_때_위_칸으로_이동() {
        List<String> expectedUpShape = List.of(" O ");
        List<String> expectedDownShape = List.of("   ");
        String inputNextStep = "U";
        boolean canMove = true;
        playerBridge.moveNextStep(inputNextStep, canMove);
        List<String> upShape = playerBridge.getUpShape();
        List<String> downShape = playerBridge.getDownShape();

        Assertions.assertThat(upShape).isEqualTo(expectedUpShape);
        Assertions.assertThat(downShape).isEqualTo(expectedDownShape);
    }

    @Test
    void 위_칸으로_이동_불가능할_때_위_칸으로_이동() {
        List<String> expectedUpShape = List.of(" X ");
        List<String> expectedDownShape = List.of("   ");
        String inputNextStep = "U";
        boolean canMove = false;
        playerBridge.moveNextStep(inputNextStep, canMove);
        List<String> upShape = playerBridge.getUpShape();
        List<String> downShape = playerBridge.getDownShape();

        Assertions.assertThat(upShape).isEqualTo(expectedUpShape);
        Assertions.assertThat(downShape).isEqualTo(expectedDownShape);
    }

    @Test
    void 아래_칸으로_이동_가능할_때_아래_칸으로_이동() {
        List<String> expectedUpShape = List.of("   ");
        List<String> expectedDownShape = List.of(" O ");
        String inputNextStep = "D";
        boolean canMove = true;
        playerBridge.moveNextStep(inputNextStep, canMove);
        List<String> upShape = playerBridge.getUpShape();
        List<String> downShape = playerBridge.getDownShape();

        Assertions.assertThat(upShape).isEqualTo(expectedUpShape);
        Assertions.assertThat(downShape).isEqualTo(expectedDownShape);
    }

    @Test
    void 아래_칸으로_이동_불가능할_때_아래_칸으로_이동() {
        List<String> expectedUpShape = List.of("   ");
        List<String> expectedDownShape = List.of(" X ");
        String inputNextStep = "D";
        boolean canMove = false;
        playerBridge.moveNextStep(inputNextStep, canMove);
        List<String> upShape = playerBridge.getUpShape();
        List<String> downShape = playerBridge.getDownShape();

        Assertions.assertThat(upShape).isEqualTo(expectedUpShape);
        Assertions.assertThat(downShape).isEqualTo(expectedDownShape);
    }
}