package bridge.domain;

/**
 * PLAYING : 게임을 진행 하는중
 * FAIL : 게임을 실패해서 종료한 경우
 * ENDING : 다리를 끝까지 도달해서 게임을 종료하는경우
 */
public enum Status {
    PLAYING, FAIL, ENDING
}
