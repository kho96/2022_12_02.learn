# 프로젝트 소개
android studio, java로 만든 버킷리스트 애플리케이션입니다.
![메인 이미지]()(https://github.com/kho96/android-project/blob/master/readme-img/main-img.png)
## 목차
1. [프로젝트 선정 이유](#프로젝트선정-이유)
2. [프로젝트 설명](#프로젝트-설명)
3. [화면 흐름도](#flowchart)
4. [실행 화면](#실행-화면)
5. [개발 후기](#개발-후기)

## 프로젝트 선정 이유
SQLite DB를 이용한 CRUD작업을 목표로하여 가벼운 애플리케이션 제작을 목표로 선정하였습니다.

## 프로젝트 설명
- 개발 환경 : 안드로이드 스튜디오(Java)
- 사용 DB : SQLite

|컬럼명|데이터 타입|제약 조건|
|:---:|:---:|:---:|
|goal|varchar(100)|primary key|
|progress_rate|number(3)|check (progress_rate between 0 and 100) default 0|
|detail_goal|varchar(500)|-|

## flowchart

![flowchart](https://github.com/kho96/android-project/blob/master/readme-img/flowchart.png)

## 실행 화면
* <strong>앱 실행 시, 메인화면 출력 -> 화면 터치 -> 버킷리스트 화면 전환</strong>
![view01](https://github.com/kho96/android-project/blob/master/readme-img/view01.png)

* <strong>버킷리스트 화면 -> 등록(아이콘) 클릭 -> 다이얼로그 출력 -> 취소 : 다이얼로그 닫기/버킷리스트 화면</strong>
![view02](https://github.com/kho96/android-project/blob/master/readme-img/view02.png)

* <strong>다이얼로그 입력 -> 등록 -> 등록 성공 -> 성공 메세지출력(토스트메세지) -> 버킷리스트 화면</strong><br/>
<strong>❗ 제약조건 위반(goal-varchar(100), 입력한 문자가 100바이트를 초과할 경우) 입력 실패 메세지 출력 -> 버킷리스트 화면</strong>
![view03](https://github.com/kho96/android-project/blob/master/readme-img/view03.png)


* <strong>버킷리스트 항목 클릭 -> 버킷리스트 상세 화면 이동 -> 뒤로가기 : 버킷리스트 화면으로 이동</strong>
![view04](https://github.com/kho96/android-project/blob/master/readme-img/view04.png)

* <strong>추가/수정 클릭 -> 다이얼로그 출력 -> 취소 : 다이얼로그 닫기/버킷리스트 상세 화면</strong>
![view05](https://github.com/kho96/android-project/blob/master/readme-img/view05.png)

* <strong>다이얼로그 입력 -> 등록 -> 등록 성공 -> 수정된 내용이 적용된 버킷리스트 상세 화면/</strong><br/>
**✔ 막대바(progressBar)는 진행률을 나타냄.**<br/>
**❗ 제약조건 위반(제약조건 프로젝트 설명 참조) -> 입력 실패 메세지 출력 -> 버킷리스트 화면**
![view06](https://github.com/kho96/android-project/blob/master/readme-img/view06.png)

* <strong>버킷리스트 상세 페이지 -> 삭제 -> 삭제 처리 -> 삭제 성공 메세지 -> 버킷리스트 화면</strong>
![view07](https://github.com/kho96/android-project/blob/master/readme-img/view07.png)


## 개발 후기
😵 어려웠던 점
>Java 언어를 사용함에 있어서 개념적인 부분이나 문법의 사용형태는 유사했지만,<br/>
Java GUI에서 다룬 컴포넌트들과 안드로이드에서의 위젯들이 비슷하면서도 이름이 달라 처음에 혼란스러웠습니다.<br/>
SQLite와 보여지는 레이아웃을 연동시켜 리스튜뷰에 출력하는 것에서 생각보다 많은 고민과 시간을 사용했습니다.

😲 배운 점
>SQLite DB에서 출력된 결과물을 list-view에 보여지게 하기 위해, adapter을 이용하는 부분에 대해 많이 공부하게 되었습니다.<br/>
또한, 각 레이아웃에서 위젯에 따라서 다음 액티비티를 보여지게 하는 기능과 대화상자를 원하는 형식으로 설정하여 사용할 수 있게 되었습니다.<br/>
SQLite를 이용해서 간단한 CRUD 기능 구현과 안드로이드에서 사용하는 방법을 공부하게 되었습니다.</br>
실사용을 위해, 파일을 압축하여 전송한 뒤에 실제 휴대기기에서 어플을 다운받고 실행해 보았습니다. 


🤔 아쉬웠던 점
>프로젝트 기간이 딱히 주어진 상황도 아니었고, 작업 환경도 안드로이드 스튜디오 애뮬레이터를 사용하다보니 느려서 답답하였다.<br/>
그런 상황에서 최대한 빠르게 주어진 목표를 달성하고 싶어 급하게 만들다 보니 추가적인 보완점도 많이 보였다.<br/>
또한, 안드로이드에서 사용할 수 있는 다양한 위젯을 사용하면서 API 기능도 공부하여 사용했다면.. 더욱 많은 공부가 되었을 것 같다.</br>
다음에 시간이 생긴다면, 꼭 ver2를 만들어 보완해야할 부분을 보완하고 추가적인 기능도 넣어 보고 싶다.







