package bridge.Model;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean canCrossing(UserChoice userChoice, int index){
        String partOfBridge = bridge.get(index);
        String choice = userChoice.getChoice();
        return partOfBridge.equals(choice);
    }
}
