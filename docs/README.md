# 🎖️ 4주차 과제
- 이미 구현된 클래스를 최대한 이용
- 각 클래스의 모든 메서드에 단위 테스트 작성 (Input, Output 제외)
- Controller, Input, Output 테스트는 ApplicationTest에 작성
- 검증은 Input에서 끝내고, 나머지 검증은 테스트 코드로 확인
- Input에서 Exception을 발생 시키고 Controller에서 에러 메시지 출력

---
## 🚀 구현 기능 목록
- InputView
  - [x] 다리의 길이 입력
  - [x] 이동할 칸 입력
  - [x] 게임을 다시 시도할지 종료할지 여부 입력


- BridgeGameController
  - [x] 사용자가 다리 길이 입력
  - [x] 사용자가 입력한 다리 길이로 다리 생성
  - [x] 사용자가 다리 이동
  - [x] 이동에 실패하면 retry 메소드 실행
  - [x] 이동에 성공하면 다시 이동할 칸 입력
  - [x] 끝까지 이동한 경우 결과 출력


- BridgeGame
  - [x] 사용자가 칸을 이동하는 기능
  - [x] 사용자가 게임을 다시 시도하는 기능


- BridgeMaker
  - [x] 입력받은 길이에 해당하는 다리 생성


- OutputView
  - [x] 현재 상태의 다리 출력
  - [x] 게임의 최종 결과 출력

---
## ⭐️ 검증 목록

- [x] 다리 길이가 3~20범위에 있는지 검증
- [x] 사용자가 이동할 칸 입력이 U,D인지 검증
- [x] 사용자가 종료 여부 입력이 R,Q인지 검증

---
## ✔️ 단위 테스트 목록
- BridgeGame
  - [x] MoveCommand에 맞게 이동하는지 테스트
  - [x] GameCommand에 맞게 재시작 하는지 테스트


- BridgeMaker
  - [x] 입력받은 길이와 생성된 다리의 길이가 같은지 테스트
  - [x] 칸의 정보가 U,D만 있는지 테스트


- Application
  - [x] 총 시도한 횟수가 올바른지 테스트
  - [x] 게임을 종료했을때 출력 결과가 올바른지 테스트 
  - [x] MoveCommand 예외 테스트
  - [x] GameCommand 예외 테스트
  - [x] 다리 길이 범위 예외 테스트

---
## 🚨 에러 메시지 목록

- [ERROR] 다리 길이는 숫자를 입력해야 합니다.
- [ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
- [ERROR] R,Q를 입력해 주세요.
- [ERROR] U,D를 입력해 주세요.
- [ERROR] 다리는 0,1로 칸을 정해야 합니다.