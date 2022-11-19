package bridge;
import java.util.List;

public class BridgeSafetyCheck {


   public GameResultCondition checkChooseBridgeSafety(String moving, List<String> bridge, int count){
       return GameResultCondition.of(moving,bridge.get(count));
   }



}
