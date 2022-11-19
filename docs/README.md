# 프로그램 설명
>- 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
>- 사용자의 입력을 통해 다리의 길이를 결정한다.
>- 위 칸과 아래 칸 중 이동할 칸을 결정한다.
>- 이동에 실패한 경우 재시작할 수 있다.
>- 끝까지 이동하거나, 이동 실패 후 재시작하지 않은 경우 게임을 종료한다.
>- 자세한 기능에 대한 설명은, 루트 디렉토리의 `README.md` 파일을 참고한다.
---

# 도메인 모델링
![img.png](domain-model.png)
>- BridgeController : 다리 생성과 게임 진행 동작(이동, 재시작)을 요청
>- BridgeMaker : 규격에 맞는 다리를 생성
>- BridgeNumberGenerator : 다리 생성에 필요한 숫자를 생성
>- BridgeGame : 게임 진행 동작(이동, 재시작, 종료)을 수행
>- BridgeCalculator : 이동 결과를 계산하고 저장
>- BridgeMonitor : 화면(콘솔) 출력 용 다리 이동 현황 기록
---

# 기능 구현 목록

## UI
### InputView
- [ ] 다리 길이 입력
- [ ] 이동할 방향(moving) 입력
- [ ] 게임 재시작 여부(game command) 입력

### OutputView
- [ ] 게임 시작 안내
- [ ] 다리 이동 현황 출력
- [ ] 최종 게임 결과 출력
---

## Controller
### BridgeController
- [x] 다리 게임 생성
- [ ] 한 턴의 이동 요청
- [ ] 게임 종료
---

## Domain
### BridgeMaker
- [x] 다리 생성
  - [x] 숫자를 이동 방향으로 변환

### BridgeRandomNumberGenerator
- [x] 랜덤 숫자 생성 (기작성된 코드)

### BridgeGame
- [ ] 한 턴의 이동 후 현황 반환
- [ ] 재시작 여부 판별
- [ ] 종료 여부 확인
- [ ] 게임 상태 확인
  - [ ] 진행 중인지 확인
  - [ ] 실패 상태인지 확인
  - [ ] 종료 상태인지 확인
- [ ] 이동 현황 반환
- [ ] 총 시도한 횟수 반환
- [ ] 유효성 검사
  - [ ] 이동할 방향(moving)
  - [ ] 게임 재시작 여부(game command)

### BridgeCalculate
- [ ] 이동 성공 여부 계산
- [ ] 게임 성공 여부 계산

### BridgeMonitor
- [ ] 한 턴의 이동 후 현황 기록
- [ ] 이동 현황 반환
---

## Constant
### (enum) GameStatus : 게임 진행 상황
- [x] 구현하기

### Moving : 이동 방향
- [x] 구현하기

### GameCommand : 게임 재시작 여부
- [ ] 구현하기

### (enum) ErrorMessage : 에러 메시지 상수 집합
- [ ] 구현하기
---

## Test
- [ ] UI 로직을 제외한 단위 테스트 작성
---
