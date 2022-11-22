package bridge.domain;

public class Attempt {
    private static final int DEFAULT = 0;
    private int count;

    private Attempt(int count) {
        this.count = count;
    }

    /**
     * 사용자가 처음 게임을 시작할 때 시도 횟수를 초기화하여 생성하는 메서드
     * @return Attempt 객체
     */
    public static Attempt begin() {
        return new Attempt(DEFAULT);
    }

    /**
     * 시도 횟수를 증가시키는 메서드
     */
    public void increase() {
        this.count++;
    }

    /**
     * 현재의 시도 횟수를 반환하는 메서드
     * @return 시도 횟수
     */
    public int getCount() {
        return count;
    }
}
