package bridge.constants;

public enum GameGuide {
    START_GUIDE("다리 건너기 게임을 시작합니다."),
    LENGTH_GUIDE("다리의 길이를 입력해주세요."),
    MOVE_GUIDE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_GUIDE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    END_GUIDE("최종 게임 결과");

    private final String guide;

    GameGuide(String guide) {
        this.guide = guide;
    }

    public String getGuide() {
        return this.guide;
    }
}
