package bridge;


public class Player {
    private int position;

    public Player() {
        position = 0;
    }

    /**
     * 플레이어의 위치를 한 칸 이동시키고 마지막 명령어를 저장하는 메서드
     * @param command 명령어 (U or D)
     */
    public void move(String command) {
        this.position += 1;
    }


    public int getIndex() {
        return position - 1;
    }

    public int getPosition() {
        return position;
    }
}
