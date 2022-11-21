# 기능 요구 사항
- [ ] Application : main loop, UI와 로직을 통합
  - [ ] 게임 진행
  - [ ] 에러 처리

- [ ] BridgeGame : 다리 건너기 게임을 관리하는 클래스
    - [ ] 게임 생성
        - [ ] 다리 생성
    - [ ] 이동
        - 위아래 칸을 받아 이동
        - 해당 칸으로 이동 가능한지 검사
    - [ ] 게임 정보 반환
        - [ ] 다리 반환
        - [ ] 현재 몇번째 칸인지 반환
        - [ ] 게임 상태(BrideGameStatus) 반환

- [ ] BridgeGameStatus : 게임 상태 정보 Enum
    - [ ] 게임 상태 정의(진행중,성공,실패)

- [x] BridgeMaker : 다리 정보를 만드는 클래스
    - [x] 다리 생성 후 반환

- [ ] InputView : 사용자로부터 입력을 받는 클래스
    - [ ] 다리 길이 입력, 검증
      - 검증 실패 시 IllegalArgumentException
    - [ ] 이동할 칸 입력, 검증
      - 검증 실패 시 IllegalArgumentException
    - [ ] 게임 재시도 여부 입력, 검증
      - 검증 실패 시 IllegalArgumentException

- [ ] OutputView : 사용자에게 게임 진행 상황과 결과를 출력하는 클래스
  - [ ] 시작 문구 출력
  - [ ] 현재까지 이동한 다리 출력
  - [ ] 게임의 최종 결과 출력
