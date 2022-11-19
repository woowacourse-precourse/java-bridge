package bridge.domain;

import bridge.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private List<String> userKeyList;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    // 유저가 입력할 키 리스트 초기화
    public void initUserKeyList() {
        userKeyList = new ArrayList<>();
    }

    // 움직인 키 입력받기
    public void move(String key) {
        userKeyList.add(key);
    }

    // Bridge 맵 반환
    public String[] getBridgeMap() {
        String[] bridgeMap = new String[userKeyList.size()];
        for (int index = 0; index < userKeyList.size(); index++) {
            String bridgeIndex = getBridge().get(index);
            String keyIndex = getUserKeyList().get(index);
            bridgeMap[index] = compareKey(bridgeIndex, keyIndex);
        }
        return bridgeMap;
    }

    // Bridge 와 key index 비교 후 O, X 반환
    private String compareKey(String bridgeIndex, String keyIndex) {
        if (bridgeIndex.equals(keyIndex)) {
            return Setting.KEY_MATCH;
        }
        return Setting.KEY_NOT_MATCH;
    }

    // 만든 다리 반환
    public List<String> getBridge() {
        return this.bridge;
    }

    // 입력한 키 리스트 반환
    public List<String> getUserKeyList() {
        return this.userKeyList;
    }

    // 입력한 키가 정답인지 아닌지 boolean 반환 기능
    public boolean isAnswer() {
        int index = userKeyList.size()-1;
        String result = compareKey(bridge.get(index), userKeyList.get(index));
        return result.equals(Setting.KEY_MATCH);
    }
}
