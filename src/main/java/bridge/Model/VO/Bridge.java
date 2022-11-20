package bridge.Model.VO;

import bridge.Enum.CrossResult;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public CrossResult cross(UserChoice userChoice, int index){
        String partOfBridge = bridge.get(index);

        if(userChoice.equals(partOfBridge)){
            return CrossResult.SUCCESS;
        }
        return CrossResult.FAIL;
    }

    public int length(){
        return bridge.size();
    }
}
