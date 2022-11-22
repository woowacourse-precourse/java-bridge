#  기능 요구사항

---


## _UI 셋팅_

---

### Inputview

- [x] 다리의 길이를 입력받기
- [x] 이동할 방향 입력
- [x] 게임 재시작 여부 입력
  
### OutputView

- [x] 게임 시작 안내
- [x] 다리 이동 내역 출력
- [x] 최종 게임 결과 출력

---

## _Controller 셋팅_

---


### BridgeController
- [x] 다리 게임 생성
- [ ] 다리 이동 요청
- [ ] 게임 종료

---
## _Domain 세팅_

---
### BridgeGame
- [x] 한 턴 이동 후 내역 반환
- [x] 재시작 여부
- [x] 종료 여부 확인
- [x] 게임 상태 확인
- [x] 이동 내역 반환
- [x] 총 시도한 횟수 반환

### BridgeCalculate
- [x] 이동 성공 여부 계산
- [ ] 게임 성공 여부 계산

### BridgeMonitor
- [x] 한턴의 이동 후 현황 기록
- [x] 이동 현황 반환

### BridgeMaker
- [x] 다리 생성
