package bridge;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public String convertNumberToUpAndDown(int number){
        for(UpAndDown upAndDown : UpAndDown.values()){
            if(upAndDown.convertNumberToUpAndDown(number) != null){
                return upAndDown.convertNumberToUpAndDown(number);
            }
        }
        return null;
    }

    public List<List<String>> convertBridgeToBridges(List<String> bridge){
        List<List<String>> bridges = createBridges(bridge.size());
        for(int i = 0; i < bridge.size(); i++){
            String block = bridge.get(i);
            String emptyBlock = " ";
            if(UpAndDown.UP.isEqualDirection(block)){
                bridges.get(UpAndDown.UP.getInputDirectionNumber()).add(block);
                bridges.get(UpAndDown.DOWN.getInputDirectionNumber()).add(emptyBlock);
            }
            if(UpAndDown.DOWN.isEqualDirection(block)){
                bridges.get(UpAndDown.DOWN.getInputDirectionNumber()).add(block);
                bridges.get(UpAndDown.UP.getInputDirectionNumber()).add(emptyBlock);
            }
        }
        return bridges;
    }

    public List<List<String>> createBridges(int size){
        List<List<String>> bridges = new ArrayList<>();
        for(int i = 0; i < size; i++){
            bridges.add(new ArrayList<>());
        }
        return bridges;
    }
}
