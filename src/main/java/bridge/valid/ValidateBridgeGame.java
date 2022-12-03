package bridge.valid;

import bridge.Constant;

import java.util.List;

public class ValidateBridgeGame {
    public List<String> validate(List<String> bridge){
        for(int i=0;i<bridge.size();i++){
            String element=bridge.get(i);
            if(element!="U"&&element!="D"){
                throw new IllegalStateException(Constant.ERROR_MESSAGE+" 올바르지 않은 다리가 생성되었습니다.");
            }
        }
        return bridge;
    }
}
