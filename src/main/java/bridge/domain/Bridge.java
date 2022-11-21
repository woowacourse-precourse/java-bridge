package bridge.domain;

import bridge.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private List<String> userKeyList;
    private int numberOfAttempts = 0;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    // 유저가 입력할 키 리스트 초기화
    public void initUserKeyList() {
        userKeyList = new ArrayList<>();
        addNumberOfAttempts(1);
    }

    // 시도횟수 number만큼 증가
    private void addNumberOfAttempts(int number) {
        this.numberOfAttempts += number;
    }

    // 움직인 키 입력받기
    public void move(String key) {
        userKeyList.add(key);
    }

    // Bridge 맵 반환
    public String[] getBridgeMap() {
        String[] bridgeMap = new String[userKeyList.size()];
        for (int index = 0; index < userKeyList.size(); index++) {
            String bridgeIndex = bridge.get(index);
            String keyIndex = getUserKeyListIndex(index);
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

    // 입력한 키 리스트의 index 값 반환
    public String getUserKeyListIndex(int index) {
        return this.userKeyList.get(index);
    }

    // 입력한 키가 정답인지 아닌지 boolean 반환 기능
    public boolean isAnswer() {
        int index = userKeyList.size()-1;
        String result = compareKey(bridge.get(index), userKeyList.get(index));
        return result.equals(Setting.KEY_MATCH);
    }

    // 시도한 횟수 반환 기능
    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }

    // 사용자 입력값이 만든 다리와 길이기 일치할경우 boolean값 반환
    public boolean isBridgeEnd() {
        return bridge.size() == userKeyList.size();
    }
}
