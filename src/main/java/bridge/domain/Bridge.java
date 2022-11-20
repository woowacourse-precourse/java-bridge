package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = new ArrayList<>(bridge);
   }

   public boolean isCorrect(int index, String bridgeType){
        return bridge.get(index).equals(bridgeType);
   }
}
