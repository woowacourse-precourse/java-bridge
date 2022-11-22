package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int LOWER_BOUND_INCLUDE = 3;
    private static final int UPPER_BOUND_INCLUDE = 20;
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사이즈를 받아 다리를 생성하는 팩터리 메서드
     * @param bridge: 문자열로 이루어진 다리 리스트
     * @return Bridge 객체
     */
    public static Bridge of(List<String> bridge) {
        validate(bridge);
        return new Bridge(bridge);
    }

    /**
     * 사용자가 처음 다리를 건너기 시작하기 위한 Bridge 팩터리 메서드
     * @return Bridge 객체
     */
    public static Bridge start() {
        return new Bridge(new ArrayList<>());
    }

    /**
     * 길이에 대한 예외처리를 하는 메서드
     * @param bridge: 문자열 리스트로 이루어진 다리
     */
    private static void validate(List<String> bridge) {
        if (bridge.size() < LOWER_BOUND_INCLUDE || bridge.size() > UPPER_BOUND_INCLUDE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 다리의 길이를 반환하는 메서드
     * @return size: 다리의 길이
     */
    public int getBridgeLength() {
        return bridge.size();
    }

    /**
     * 다리의 길이와 사용자가 건너는 중인 길이를 비교해 게임의 진행 여부를 반환하는 메서드
     * @param user: 사용자가 건너는 중인 다리의 길이
     * @return 게임의 진행여부
     */
    public boolean isProceeding(Bridge user) {
        return this.getBridgeLength() > user.getBridgeLength();
    }

    /**
     * 한칸 이동한 유저의 상태를 문자열 리스트로 반환하는 메서드
     * @param moving: U 또는 D
     * @return 한칸 이동한 상태의 유저 Bridge 객체
     */
    public Bridge move(String moving) {
        List<String> next = new ArrayList<>(this.bridge);
        next.add(moving);
        return new Bridge(next);
    }

    /**
     * 다리 건너기 게임의 성공 여부를 반환하는 메서드
     * @param user: 사용자의 현재 진행상태 Bridge 객체
     * @return 건너기의 성공 여부
     */
    public boolean isSuccess(Bridge user) {
        return !getMap(user).contains("X");
    }

    /**
     * 다리와 사용자의 진행 상태를 비교하여 OX 형태의 Map을 String 으로 반환하는 메서드
     * @param user: 사용자 진행상태 Bridge 객체
     * @return OX 형태의 Map 문자열
     */
    public String getMap(Bridge user) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < user.getBridgeLength(); index++) {
            if (user.canJump(index, bridge.get(index))) {
                stringBuilder.append("O");
                continue;
            }
            stringBuilder.append("X");
        }
        return stringBuilder.toString();
    }

    /**
     * 다리 한칸 건너기의 성공여부를 반환하는 메서드
     * @param index: 검사하는 인덱스
     * @param line: U 또는 D
     * @return 한칸 건너기의 성공 여부
     */
    public boolean canJump(int index, String line) {
        return bridge.get(index).equals(line);
    }
}
