## 기능 구현 사항
- 다리를 생성한다.
  - [x] 입력한 사이즈만큼 0과 1 중 무작위 값을 생성한다.
  - [x] enum class를 이용하여 숫자와 심볼의 결합도를 높인다.
- 생성한 다리로 게임을 시작한다.
  - [x] 입력한 칸으로 이동한다.
    - 이동할 수 있는 칸
      - [x] 게임을 계속 진행한다.
    - 이동할 수 없는 칸
      - [x] 게임의 재시도 여부를 묻는다.
        - 재시도 선택
          - [x] 게임을 처음부터 다시 시작한다.
        - 종료 선택
          - [x] 게임 종료 진행
- 게임 종료 (다리 끝 도착 or 종료 선택)
  - [x] 최종 게임 결과를 출력한다.
  - [x] 총 시도한 횟수를 출력한다.
  
## 예외 처리
- 다리 생성
  - [x] 사이즈 입력 범위 3부터 20사이 (IllegalArgument)
  - [x] BridgeNumberGenerator가 0과 1이 아닌 숫자로 다리를 생성할 경우 (IllegalArgument)
- 게임 진행
  - [x] 이동할 칸 입력 시 "U" 또는 "D" 가 아닐 경우 (IllegalArgument)
  - [x] 더 이상 이동할 곳이 없는 경우 (IllegalState)
  - [x] 재시도 여부 입력 시 "R" 또는 "Q" 가 아닐 경우 (IllegalArgument)

## Idea Note
  - 게임 진행 결과 출력 방법: BridgeGame의 History를 기록
  - 게임 시도 횟수: 재시도마다 BridgeGame의 trial 필드 증가
  - 다리 끝 도착: BridgeGame의 성공 조건을 만족하는지 체크하는 메소드(isSuccess) 작성
  - BridgeNumberGenerator와 Bridge의 결합도 증가: enum class 활용
  - 올바른 gameCommand 체크: enum class 활용

