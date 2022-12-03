package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeStatus;
import bridge.domain.CurrentBridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {

     CurrentBridge currentBridge = new CurrentBridge(new ArrayList<>());
     @Test
     @DisplayName("다리 이동 테스트")
     public void moveTest() throws Exception{
          currentBridge.move("U");
          Assertions.assertThat(currentBridge.getBridge(0))
                  .isEqualTo("U");
     }
     @Test
     @DisplayName("다리 이동 테스트 - 여러번")
     public void moveTestMany() throws Exception{
          currentBridge.move("U");
          currentBridge.move("U");
          currentBridge.move("D");
          currentBridge.move("U");
          Assertions.assertThat(currentBridge.bridgeLength())
                  .isEqualTo(4);
          unit(0,"U");
          unit(1,"U");
          unit(2,"D");
          unit(3,"U");
     }
     private void unit(int index,String expect){
          Assertions.assertThat(currentBridge.getBridge(index))
                  .isEqualTo(expect);
     }

     @Test
     @DisplayName("다리 상태 변경 테스트 - BridgeStatus.SUCCESS")
     public void changeStatusTest() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          currentBridge.move("U");
          currentBridge.changeStatus(bridge);
          Assertions.assertThat(currentBridge.getBridgeStatus())
                  .isEqualTo(BridgeStatus.SUCCESS);
     }
     @Test
     @DisplayName("다리 상태 변경 테스트 - BridgeStatus.FAIL")
     public void changeStatusTest_Fail() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"D",BridgeStatus.FAIL);
     }
     @Test
     @DisplayName("다리 상태 변경 테스트 - BridgeStatus.COMPLETE")
     public void changeStatusTest_COMPLETEl() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"D",BridgeStatus.COMPLETE);
     }

     private void unit(Bridge bridge,String cmd,BridgeStatus expect){
          currentBridge.move(cmd);
          currentBridge.changeStatus(bridge);
          Assertions.assertThat(currentBridge.getBridgeStatus())
                  .isEqualTo(expect);
     }

     @Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV1() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"D",BridgeStatus.COMPLETE);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo("OO   O");
     }
     @Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV2() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"U",BridgeStatus.FAIL);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo("OOX   ");
     }
     @Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV3() throws Exception{
          Bridge bridge = new Bridge(List.of("U","U","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo("O ");

     }@Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV4() throws Exception{
          Bridge bridge = new Bridge(List.of("D"));
          unit(bridge,"U",BridgeStatus.FAIL);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo("X ");
     }
     @Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV5() throws Exception{
          Bridge bridge = new Bridge(List.of("U"));
          unit(bridge,"D",BridgeStatus.FAIL);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo(" X");
     }
     @Test
     @DisplayName("다리 이동 상태 출력 테스트")
     public void printV6() throws Exception{
          Bridge bridge = new Bridge(List.of("U","D","D"));
          unit(bridge,"U", BridgeStatus.SUCCESS);
          unit(bridge,"D",BridgeStatus.SUCCESS);
          unit(bridge,"D",BridgeStatus.COMPLETE);
          Assertions.assertThat(currentBridge.toString())
                  .isEqualTo("O   OO");
     }

     @Test
     @DisplayName("게임 다시 시도 테스트")
     public void retry() throws Exception{
          Bridge bridge = new Bridge(List.of("U","D","D"));
          unit(bridge,"U",BridgeStatus.SUCCESS);
          unit(bridge,"U",BridgeStatus.FAIL);
          currentBridge.reset();
          Assertions.assertThat(currentBridge.bridgeLength()).isEqualTo(0);
          Assertions.assertThat(currentBridge.getBridgeStatus()).isEqualTo(BridgeStatus.SUCCESS);
     }




}