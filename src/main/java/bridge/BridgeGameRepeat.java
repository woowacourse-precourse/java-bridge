package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGameRepeat {
    public static String gamerepeat(boolean check, int bridge_index, int bridge_size,int cnt){
        String result = null;
        String blank="";
        BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge=bridgeMaker.makeBridge(bridge_size);
        List<Integer> list =  new ArrayList();
        List<String> list2 =  new ArrayList();
        System.out.println(bridge);
        while (check==true){
            if(bridge_index==bridge_size){
                OutputView.printResult(result,cnt,1);
                return "";
            }
            blank=InputView.readMoving();
            //맞췄을시
            if(Objects.equals(bridge.get(bridge_index), blank)){
                list.add(1);
                list2.add(blank);
                bridge_index+=1;
                result=OutputView.printMap(list,list2,bridge_index);
                continue;
            }
            check=false;
            list.add(0);
            list2.add(blank);
            bridge_index+=1;
            result=OutputView.printMap(list,list2,bridge_index);
        }
        return result;
    }

}
