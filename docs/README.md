# 순서도

1. "다리 건너기 게임을 시작합니다." 를 출력한다.
2. "다리의 길이를 입력해주세요." 를 출력한다.
3. 다리의 길이를 입력받는다.
4. 다리의 길이 문자열이 유효한지 검증한다.
    - 다리의 길이 문자열이 정수(Integer)인가?
    - 다리의 길이가 3부터 20사이의 수 인가?
5. 다리의 길이 만큼 다리를 만든다.
6. 다리의 길이 만큼 반복한다.
    1. "이동할 칸을 선택해주세요. (위: U, 아래: D)" 를 출력한다.
    2. 이동할 칸 문자열을 입력받는다.
    3. 이동할 칸 문자열이 유효한지 검증한다.
        - 이동할 칸 문자열이 U 또는 D 인가?
    4. 다리 건너기 결과를 출력한다.
    5. 다리 건너기 결과 분기
        1. 게임에 실패한다면 "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 를 출력한다.
        2. 재시도 여부 문자열을 입력 받는다.
        3. 재시도 문자열이 유호한지 검증하다.
            - 재시도 문자열이 R 또는 Q 인가?
        4. 재시도 분기
            1. 재시도 문자열이 R 이면 결과 출력을 초기화하고, 5번 순서로 이동한다.
            2. 재시도 문자열이 Q 이면 종료한다(반복문 탈출).
7. "최종 게임 결과" 를 출력한다.
8. 다리 건너기 최종 결과를 출력한다.
9. "게임 성공 여부: " + (성공 또는 실패) 를 출력한다.
10. "총 시도한 횟수: " + (총 시도 횟수) 를 출력한다.

# 기능 목록

## InputView Class

- public readBridgeSize method
    - "다리의 길이를 입력해주세요." 를 출력한다.
    - 다리의 길이 매개변수를 읽고, 유효한지 검증 후 다리의 길이를 int 형태로 반환한다.
- private validateBridgeSize method
    - 다리의 길이 매개변수가 유효한지 검증한다.
- public readMoving method
    - "이동할 칸을 선택해주세요. (위: U, 아래: D)" 를 출력한다.
    - 이동할 칸 매개변수를 읽고, 유효한지 검증 후 이동할 칸을 String 형태로 반환한다.
- private validateReadMoving method
    - 이동할 칸 매개변수가 유효한지 검증한다.
- public readGameCommand method
    - "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 를 출력한다.
    - 재시작 매개변수를 읽고, 유효한지 검증 후 재시작 명령을 String 형태로 반환한다.
- private validateGameCommand method
    - 재시작 매개변수가 유효한지 검증한다.

## OutputView Class

- public printMap method
    - 다리를 출력한다.
- public printResult method
    - 다리와 게임 성공 여부, 총 시도한 횟수를 출력한다.

## BridgeGame Class

- public move method
    - 다리를 움직인다.
- public retry method
    - 다리를 초기화한다.
- public getMoveResult method
    - 움직인 다리의 결과를 반환한다.

## BridgeMaker Class

- makeBridge method
    - 다리의 길이와 BridgeRandomNumberGenerator 통해 수가 1 이면 "U", 수가 0 이면 "D" 의 문자열 리스트를 반환한다.
