package bridge.Model.VO;

import bridge.ChoiceResult;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public ChoiceResult canCrossing(UserChoice userChoice, int index){
        String partOfBridge = bridge.get(index);

        if(userChoice.equals(partOfBridge)){
            return ChoiceResult.SUCCESS;
        }
        return ChoiceResult.FAIL;
    }
}
