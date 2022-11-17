#  Bridge

## 기능 목록
- [ ] 생성할 다리의 길이를 입력 받는다.
  - <span style ="color:red">[ERROR]</span> 3이상~20이하의 범위가 아니다.
  - <span style ="color:red">[ERROR]</span> 숫자를 입력 하지 않았다.
- [ ] 다리를 생성한다.
  - 무작위 값을 받아서 0인경우 아래칸, 1일 경우 위칸으로 건널 수 있는 칸으로 정한다
  - <span style ="color:red">[ERROR]</span> 0과 1외의 값을 받았다.
- [ ] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력받아 이동한다.
  - <span style ="color:red">[ERROR]</span> U와 D외의 값을 입력하였다.
  - <span style ="color:red">[ERROR]</span> 하나의 값을 입력하지 않았다.
- [ ] 이동한 칸이 건널 수 있는 칸인지 확인한다
  - 건널 수 있는 칸은 U값으로, 건널 수 없는 칸은 D값으로 나타낸다.
  - 건널 수 있는 칸이면 게임을 계속 진행한다
  - 건널 수 없는 칸이면 게임 재시작 여부를 R(재시작)과 Q(종료) 중 하나의 문자를 입력받는다.
    - <span style ="color:red">[ERROR]</span> R과 Q외의 값을 입력하였다.
    - <span style ="color:red">[ERROR]</span> 하나의 값을 입력하지 않았다.
- [ ] 이동할 때마다 현재 까지 건넌 다리 건너기 결과를 출력한다