package Constant;


import java.util.List;

public enum BridgeMakerConstant {
    BRIDGE_ROUTE(List.of("U","D"));


    private final List<String> route;
    BridgeMakerConstant(List<String> input){
        this.route = input;
    }
    public String getValue(int idx){
        return route.get(idx);
    }
    public int getBranchNum(){
        return route.size();
    }
}
