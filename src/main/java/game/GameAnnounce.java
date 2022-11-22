package game;

public enum GameAnnounce {

    start("다리 건너기 게임을 시작합니다. \n 다리의 길이를 입력해주세요."),
    userMove("이동할 칸을 선택해주세요. (위:U, 아래:D)"),
    userRestart("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    finish("최종 게임 결과"),
    success("게임 성공 여부: 성공 \n 총 시도한 횟수: "),
    fail("게임 성공 여부: 실패 \n 총 시도한 횟수: ");

    private final String announcement;

    private GameAnnounce(String announcement) {
        this.announcement = announcement;
    }

    public String getAnnouncement() {
        return this.announcement;
    }
}
