package bridge;

import bridge.enums.BlockExpression;
import bridge.enums.MovingDirection;

import java.util.ArrayList;
import java.util.List;

public class BridgeChecker {

    public List<String> checkBridgeMatching(List<String> bridge, List<String> userInput) {
        List<String> matchingResult = new ArrayList<>();

        for(int i=0; i<userInput.size(); i++) {
            if(bridge.get(i).equals(userInput.get(i))==false) {
                matchingResult.add(BlockExpression.Diff.getMark());
                break;
            }
            matchingResult.add(BlockExpression.Same.getMark());
        }
        return matchingResult;
    }

    public List<String> checkUpperBlocks(List<String> matchingResult, List<String> bridge) {
        List<String> upperBlocks = new ArrayList<>();

        for(int i=0; i<matchingResult.size(); i++) {
            if(bridge.get(i).equals(MovingDirection.Upper.getDirection())) {
                upperBlocks.add(matchingResult.get(i));
            }else if(bridge.get(i).equals(MovingDirection.Lower.getDirection())) {
                upperBlocks.add(BlockExpression.Empty.getMark());
            }
        }
        return upperBlocks;
    }

    public List<String> checkLowerBlocks(List<String> matchingResult, List<String> bridge) {
        List<String> lowerBlocks = new ArrayList<>();

        for(int i=0; i<matchingResult.size(); i++) {
            if(bridge.get(i).equals(MovingDirection.Lower.getDirection())) {
                lowerBlocks.add(matchingResult.get(i));
            }else if(bridge.get(i).equals(MovingDirection.Upper.getDirection())) {
                lowerBlocks.add(BlockExpression.Empty.getMark());
            }
        }
        return lowerBlocks;
    }
}
