package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private List<String> bridgeUpMap;
    private List<String> bridgeDownMap;


    public BridgeMap(int size){
        bridgeUpMap = new ArrayList<>();
        bridgeDownMap = new ArrayList<>();
        initBridgeMap(size);
    }

    public List<String> getBridgeUpMap(){
        return bridgeUpMap;
    }
    public List<String> getBridgeDownMap(){
        return bridgeDownMap;
    }
    public void makeBridgeMap(int location,String moving,String result){
        if(moving.equals("U")){
            makeBridgeUpMap(location,result);
        }
        if(moving.equals("D")){
            makeBridgeDownMap(location,result);
        }
    }

    public void makeBridgeUpMap(int location,String result){
        bridgeUpMap.set(location, result);
    }


    public void makeBridgeDownMap(int location,String result){
        bridgeDownMap.set(location, result);
    }


    public void initBridgeMap(int size){
        for(int i=0;i<size;i++){
            bridgeUpMap.add(" ");
            bridgeDownMap.add(" ");
        }
    }
}