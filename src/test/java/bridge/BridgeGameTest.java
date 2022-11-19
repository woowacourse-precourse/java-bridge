package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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




}