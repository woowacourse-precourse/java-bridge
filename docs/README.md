미션 - 다리건너기
===
---
기능목록
---
1. **UI**

    + InputView
        - 시작 메시지 출력
        - 다리 길이 입력 요청 출력
        - 다리 길이 input 받기
        - 이동할 칸 입력 요청 출력
        - 이동할 칸 input 받기
        - 재시작 혹은 종료 입력 요청 출력
        - 재시작 혹은 종료 input 받기
    + OutputView
        - 최종 게임 결과 다리 출력
        - 게임 성공 여부 출력
        - 총 시도한 횟수 출력


2. **Service**
    + BridgeGame
        - 다리 건너기
        - 매 input 성공 여부 판정
        - 게임 전체 성공 여부 판정
        - 재시작 여부 판정
        - 사용자의 건너는 input 저장
        - 재시작 시 사용자 건너는 input 초기화
        - [예외] 건너기 : input이 U 혹은 D가 아닌 경우
        - [예외] 재시작 : input이 R 혹은 Q가 아닌 경우
    + BridgeMaker
        - 다리 사이즈에 따라 다리 List 생성
        - [예외] input이 숫자가 아닌 경우
        - [예외] input이 3 이상 20 이하가 아닌 경우

3. **Controller**
    + GameController
        - 게임 전체 돌리기
        - 게임 시작
            * size 받기
            * 게임에 사용될 답안 bridge 만들기
        - 게임 한 사이클 돌리기
            * InputView에서 칸 입력
            * 이동
            * 결과 검증
            * 게임오버 시 재시작 여부 검증
        - 종료 시 결과 출력
    
4. **Model**
    + Direction
        - UP('U', 1)
        - DOWN('D', 0)
    + Bridge
        - START("[ ")
        - END(" ]")
        - MID(" | ")
    + Answer
        - CORRECT("O")
        - INCORRECT("X")
        - NONE(" ")
        - END("END")
    + Restart
        - TRUE("R")
        - FALSE("Q")
    + Result
        - SUCCESS("성공")
        - FAILED("실패")
    + GameMessage
        - START_GAME("다리 건너기 게임을 시작합니다.")
        - GET_SIZE("다리의 길이를 입력해주세요.")
        - GET_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        - GAME_RESULT("최종 게임 결과")
        - GET_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        - IS_SUCCESS("게임 성공 여부: ")
        - TOTAL_TRY("총 시도한 횟수: ")
    + ErrorMessage
        - NULL_INPUT_ERROR("값을 입력해주세요")
        - NOT_NUMERIC_VALUE_ERROR("[ERROR] 숫자인 값을 입력해주세요.")
        - INVALID_NUMERIC_VALUE("[ERROR] 3 이상 20 이하의 값을 입력해주세요")
        - INVALID_DIRECTION_VALUE("[ERROR] U 혹은 D를 입력해주세요.")
        - INVALID_RESTART_VALUE("[ERROR] R 혹은 Q를 입력해주세요.")