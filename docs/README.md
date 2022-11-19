# 구현할 기능 목록

#### [구체화 및 구현 과정](./PROCESS.md)

- InputView
  - [x] 공통 : 에러 발생시, 값을 다시 입력받음
  - [x] 다리의 길이를 입력받음
      - 3 이상 20 이하의 숫자를 입력하지 않으면 `IllegalArgumentException` 에러 발생
  - [ ] 플레이어가 이동할 칸을 입력받음
      - 주어진 특정문자(U, D)외의 문자를 입력받으면 `IllegalArgumentException` 에러 발생
  - [ ] 게임 재시작 / 종료 여부를 입력 받는다.
      - 주어진 특정문자(R, Q)외의 문자를 입력받으면 `IllegalArgumentException` 에러 발생
  
- OutputView
  - [ ] 게임 시작 문구 출력
  - [ ] 다리의 현재 진행 상황 출력
  - [ ] 실패시, 재시작을 묻는 문구 출력
  - [ ] 게임 종료 문구 출력


- BridgeGame
    - [x] 앞으로 움직이는 기능 구현
    - [x] 재시작시 이동한 것을 초기화하는 기능 구현
    - [x] 현재 계속 건널 수 있는 상태인지 확인하는 기능 구현
- BridgeMaker
    - [x] bridge를 만듦
      - BridgeNumberGenerator 에서 0을 전달하면 아래를 추가, 1을 전달하면 위를 추가함
      - 위는 'U' 아래는 'D'를 넣어서 List<String> 형태로 구현