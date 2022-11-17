**필요 기능 목록**
- [x] 길이에 맞는 다리 생성 기능 (1)
- [x] BridgeGame 초기화 기능 (2)
- [X] 입력된 이동에 따른 진행 상황 계산 기능 (3)
- [X] 사용자의 직전 경로 초기화 기능 (4)
- [ ] 게임 관리 기능 (재시도 or 종료 / 시도 횟수) (5)
- [ ] 다리 길이 입력 인터페이스 (InputView - BridgeGame) (6)
- [ ] 이동 입력 인터페이스 (InputView - BirdgeGame) (7)
- [ ] 진행 상황 출력 인터페이스 (OutputView - BridgeGame) (8)
- [ ] 게임 결과 출력 인터페이스 (OutputView - BirdgeGame) (9)

**예외 사항 목록**  
&rarr; IllegalArgumentException 발생 후 발생 시점 전으로 회귀해야 함
- 다리 길이 입력 확인
  - [ ] 3이상 20이하의 숫자인지 체크
- 이동할 칸 입력 확인
  - [ ] U 또는 D 인지 체크
- 게임 재시작/종료 여부 입력 확인
  - [ ] R 또는 Q 인지 체크