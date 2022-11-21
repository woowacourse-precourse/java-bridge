## 📝 기능 명세 & 예외 상황
- [ ] 다리 생성 (BridgeMaker#makeBridge)
  - [ ] 다리 길이 입력
  - [ ] 다리 길이 유효성 검증 (정수, 범위)
  - [x] 길이에 맞게 "U", "D"로 이뤄진 다리 생성

- [ ] 사용자 이동 (BridgeGame#move)
  - [ ] 사용자 이동 입력 (위: U, 아래: D)
  - [ ] 사용자 이동 유효성 검증 (only 'U', 'D')
  - [ ] 사용자 이동마다 화면에 이동을 출력

- [ ] 사용자 재시도 (BridgeGame#retry)
  - [ ] 사용자 재시도 입력 (재시작: R, 종료: Q)
    - [ ] 재시작 입력시 재시작해도 처음에 만든 다리로 재사용 (싱글톤 패턴)
  - [ ] 사용자 재시도 입력 유효성 검증 (only 'R', 'Q')

**게임 결과**
- [ ] 최종 게임 결과 출력
- [ ] 게임 성공 여부
- [ ] 총 시도 횟수 계산 

## 🚀 도메인

### BridgeGame
- move(): 사용자가 칸을 이동할 때 사용하는 메서드
- retry(): 사용자가 게임을 다시 시도할 때 사용하는 메서드

### BridgeMaker
- makeBridge: BridgeNumberGenerator를 이용한 구현 

### Direction
- 위 아래 방향 Enum 클래스
- number(1, 0), initial(U, D)
  - getInitialByDirectionNumber(int directionNumber)

### Player
- 사용자 클래스 

### Result
- 사용자의 이동에 결과를 담는 클래스

### BridgeGameStatus
- 게임 진행 여부 Enum 클래스
- PLAY("R"), QUIT("Q")

### Round
- nextRound: 다음 라운드로 이동
- reset: 라운드에 MovingResult Fail 시에 reset

### MovingResult
- 사용자 이동에 따른 결과를 담는 클래스
