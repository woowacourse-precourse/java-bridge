# 설계
레이어 패키지 구조 사용
- 프로젝트 규모 발전에 대한 우려가 없다고 판단해 모듈 단위로의 분리를 요하지 않으므로 해당 패키지 구조를 선택
- domain, util, view

## 시나리오
1. 게임 시작 문장 출력 → `OutputView`
2. 다리 길이 입력문 출력 → `OutputView`
3. 다리 길이 입력 → `InputView`
    1. 예외 처리 → `Validator`
4. 입력에 맞는 다리 생성 → `BridgeNumberGenerator`, `BridgeRandomNumberGenerator`, `BridgeMaker`
5. 이동 칸 입력문 출력 → `OutputView`
6. 이동 칸 입력 → `InputView`
    1. 예외 처리 → `Validator`
7. 다리 이동 결과 출력 → `OutputView`
8. 게임 상태 변경 → `Status`
    1. 성공, 끝 도달 X → 5로 이동
    2. 성공, 끝 도달 O
        1. “최종 게임 결과” 출력 → `OutputView`
        2. 다리 이동 결과 출력 → `OutputView`
        3. “게임 성공 여부: 성공” 출력 → `OutputView`
        4. “총 시도한 횟수: {}” 출력 → `OutputView`
    3. 실패 → 9로 이동
9. 게임 추가 여부 입력문 출력 → `OutputView`
10. 게임 추가 여부 입력 → `InputView`
    1. 예외 처리 → `Validator`
11. 게임 상태 변경 → `Status`
    1. 재시도 → 5로 이동
    2. 종료
        1. “최종 게임 결과” 출력 → `OutputView`
        2. 다리 이동 결과 출력 → `OutputView`
        3. “게임 성공 여부: 실패” 출력 → `OutputView`
        4. “총 시도한 횟수: {}” 출력 → `OutputView`

## 필요한 기능
- [x]  다리 길이 입력
- [x]  다리 길이 입력에 대한 예외 처리
- [x]  다리 생성
- [x]  이동 칸 입력
- [x]  이동 칸 입력에 대한 예외 처리
- [x]  다리 이동
  - 우선, 사용자의 입력 리스트를 저장하고 이를 다리와 비교하는 방식 구현
- [x]  다리 이동 결과 출력
- [x]  게임 상태 변경
- [x]  게임 추가 여부 입력
- [x]  게임 추가 여부 입력에 대한 예외 처리
- [x]  게임 종료에 대한 출력

## 리팩토링
- 패키지 구조 변경
  - `domain`, `view`, `util`, `error`
- **`error/ErrorMessage`** 생성
- 클래스 필드 접근자 확인
- 메소드 인덴트 확인
- 메소드 라인 확인

## 필요한 클래스
- **`util/Validator`**
    - 역할 : 입력에 대한 예외 처리
    - 예외 발생 시, IllegalArgumentException을 발생시키고,
      이를 catch하는 로직에서 던져진 예외의 메세지를 출력
    - `다리 길이 숫자 여부`, `범위 내 존재 여부`
    - `이동 칸 입력 한 문자 여부`, `대문자 여부`, `U or D 여부`, `R or Q 여부`
- **`util/InputView`**
    - 역할 : 입력 처리
    - `readBridgeSize()`, `readMoving()`, `readGameCommand()`
- **`domain/Status`**
    - 역할 : 게임의 상태 관리
    - `PROCEEDING` `SUCCESS` `FAIL`
        - 게임 진행 중, 다리 건너기 완료, 건너기 실패
- **`domain/Bridge`**
    - 역할 : 다리 관리
    - `List<String> originalBridge`, `List<String> copyBridge`
        - 초기 다리 상태는 저장해둬야 함.
    - `getBridge()`
        - OutputView에 사용할 다리 출력 시 사용
    - `changeBridge(String input)`
        - 사용자 입력에 따라 다리 상태 변경
- **`domain/BridgeMaker`**
    - 역할 : 다리 생성
- **`domain/BridgeGame`**
    - 역할 : 다리 건너기 게임 관리, 상태 저장
    - `changeStatus()`
      - 다리 상태 변경
    - `isProceeding()`
      - 다리 건너기 게임이 진행 중인지 반환
- **`view/OutputView`**
    - 역할 : 출력 처리
    - `final String` 관리
- **`error/ErrorMessage`**
    - NOT_NUMBER_BRIDGESIZE(”다리 길이는 숫자여야 합니다.”)
    - INVALID_BRIDGESIZE(”다리 길이는 3 ~ 20 사이의 숫자여야 합니다.”)
    - NOT_ONE_CHAR_MOVING(”이동할 칸은 한 문자여야 합니다.”)
    - NOT_UPPER_CASE_MOVING(”이동할 칸은 대문자여야 합니다.”)
    - U_OR_D_MOVING(”이동할 칸은 U 또는 D 여야 합니다.”)
    - NOT_ONE_CHAR_COMMAND(”게임 재시작/종료 여부는 한 문자여야 합니다.”)
    - NOT_UPPER_CASE_COMMAND(”게임 재시작/종료 여부는 대문자여야 합니다.”)
    - R_OR_Q_COMMAND(”게임 재시작/종료 여부는 R 또는 Q여야 합니다.”)