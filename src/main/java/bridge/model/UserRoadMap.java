package bridge.model;

import java.util.List;

public class UserRoadMap extends RoadMap {
    public UserRoadMap(List<String> directions) {
        super(directions);
    }

    @Override
    protected void validate(List<String> directions) {
    }

    public Road getRoad(int roadPosition){
        // TODO: 위치에 해당하는 칸을 반환
        return null;
    }

    public void clear(){
        // TODO: 이동했던 칸을 모두 삭제
    }

    public void addRoad(String direction){
        // TODO: 이동할 칸에 대해 생성 및 저장
    }

    public boolean isFail(BridgeRoadMap bridgeRoadMap){
        // TODO: 마지막 이동했던 칸과 다리의 칸이 일치하는지 여부 확인
        return false;
    }
}
