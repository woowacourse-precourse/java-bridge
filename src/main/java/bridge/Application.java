package bridge;

import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        int bridge_size;
        String blank;
        int bridge_index=0;
        boolean check = true;
        //다리 길이 입력 받기
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridge_size=InputView.readBridgeSize();
        List<String> bridge=BridgeMaker.makeBridge(bridge_size);
        System.out.println(bridge);
        while (check==true){
            blank=InputView.readMoving();
            if(Objects.equals(bridge.get(bridge_index), blank)){
                System.out.println("answer");
            }
            else{
                check=false;
            }
            bridge_index+=1;
        }
        }


}
