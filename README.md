# 프로젝트 소개
android studio, java로 만든 버킷리스트 애플리케이션입니다.

## 목차
1. [프로젝트 선정 이유](#-프로젝트선정-이유)
2. [프로젝트 설명](#프로젝트-설명)
3. [실행 화면](#실행-화면)
4. 개발 후기

## 프로젝트 선정 이유
SQLite DB를 이용한 CRUD작업을 목표로하여 가벼운 애플리케이션 제작을 목표로 선정함.

## 프로젝트 설명
- 개발 환경 : 안드로이드 스튜디오(Java)
- 사용 DB : SQLite

|컬럼명|데이터 타입|제약 조건|
|:---:|:---:|:---:|
|goal|varchar(100)|primary key|
|progress_rate|number(3)|check (progress_rate between 0 and 100) default 0|
|goal|varchar(500)|-|


