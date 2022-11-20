package Constant;


import java.util.HashMap;
import java.util.List;

public enum BridgeMakerConstant {
    BRIDGE_ROUTE(List.of("U","D"));


    private final List<String> route;
    private final HashMap<String,Integer> moveIndex;
    BridgeMakerConstant(List<String> input){
        this.route = input;
        moveIndex = new HashMap<>();
        for(int i=0; i<input.size(); i++){
            moveIndex.put(input.get(i),i);
        }
    }
    public String getValue(int idx){
        return route.get(idx);
    }
    public int getBranchNum(){
        return route.size();
    }
    public HashMap<String, Integer> getHash(){
        return moveIndex;
    }
}
