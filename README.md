# DB계정 생성하기

![](https://postfiles.pstatic.net/MjAyMDExMThfMTg4/MDAxNjA1NjgwNjY4NDg1.66TAs0Gg2vkSRu90SsLBF6m36STLJaRdoQWk7HC4gywg.Al8UzqeXJpv3JVw3gW47mhoMNFLRimqozZVm13dSxsYg.JPEG.rgusqls/CMD01.jpg?type=w773)

1. 우선 CMD를 킨 후에 sqlplus를 친다.

2. Oracle에 가입한 계정이름과 비밀번호를 친다. [ system / 비밀번호 ]

3. 연결 메세지 확인하기 **[ Oracle Database 11g Express Edition Relaease 11.2.0.2.0 - 64bit Production ]**

4. SQL 계정 확인하기

   ```sql
   select * from ALL_users; --모든 계정에 대한 정보 확인
   select * from DBA_users; --모든 계정에 대한 정보 확인
   select username from ALL_users; --모든 계정에 대한 정보 확인
   select username from DBA_users; --모든 계정에 대한 정보 확인
   ```

   

5. SQL사용자 계정 생성하기

   ```sql
   create user [USERNAME] identified by [PASSWORD]
   ```

   ![](https://postfiles.pstatic.net/MjAyMDExMThfMTU2/MDAxNjA1NjgyMzM2MDcy.TI5SF8fAQJ_ZarDcgdZej6J3l9KlAo7IMYk22c5GlXEg.OSTq3BbG7eWw2w1eL6gJ1BiWLnERClgX0p3CMK952U0g.PNG.rgusqls/image.png?type=w773)

6. **[ 참고 ]** 사용자 계정 비밀번호 변경하기

   ```sql
   ALTER USER [USERNAME] IDENTIFIED BY [NEW PASSWORD]
   ```

7. 계정 권한 할당

   ```sql
   -- 이때 계정이 관리자 계정이여 한다.
   -- 대표적으로 SYS, SYSTEM 계정이고, 오라클 DB설치 시 자동으로 생성된다.
   -- SQL접속 시 [system/비밀번호]로 system 계정에 접속한다.
   -- 명령어 [conn/as sysdba]로 관리자 sys 계정에 접속할 수 있다.
   
   GRANT TO 권한명 TO 계정;
   
   -- 시스템 권한 종류
   -- create user : 데이테 베이스 유저 생성 권한
   -- select any table : 모든 유저의 테이블 조회 권한
   -- create any table : 모든 유저의 테이블 생성 권한
   -- drop any table : 테이블 삭제 권한
   -- create session : 데이터베이스 접속 권한
   -- create table : 테이블 생성권한
   -- create view : view 생성 권한
   -- create proced user : 프로시저 생성 권한
   -- create sequence : 시퀀스 생성 권한
   -- sysdba : 데이터베이스를 관리하는 최고 권한
   -- sysoper : 데이터베이스를 관리하는 권한
   
   GRANT create session to SpringBoot;
   GRANT create any table to SpringBoot;
   GRANT select any table to SpringBoot;
   GRANT drop any table to SpringBoot;
   GRANT create sequence to SpringBoot;
   
   GRANT sysoper to SpringBoot;
   
   저는 모든 권한을 주기 위해서
   GRANT connect, dba, resource TO SpringBoot; 로 주었습니다.
   ```

   ![](https://postfiles.pstatic.net/MjAyMDExMThfMjg5/MDAxNjA1Njg0MDQ2NTA4.3aI9KykkhMrnxhEE3VS6KdNbzcs0GR7Xi1icuxJD6pIg.EKi59_QjhwUBf7sVMbHfvhcIM6AlRU7C3T75I2BI_Lgg.PNG.rgusqls/image.png?type=w773)

처음에는 **sysoper**권한으로 데이터베이스를 관리하는 권한을 주려고 했으나 실패하였습니다.

**ORA-01031 : insufficient privileges** / 권한이 불충분합니다. 라는 에러가 발생했습니다.

그래서 **sys as sysdba**로 접속하여 권한을 부여할 수 있었습니다.

하지만 **create, select** 등등의 명령이 실행되지 않았습니다.

그래서 다시 **sys as sysdba**로 접속하여 위와같이 권한을 부여하였더니 정상작동 하였습니다. 

```sql
--CMD에서
sqlplus
sys as sysdba
[빈칸으로 enter]

--접속완료
```

8. 권한 제거

   ```sql
   revoke 권한명 (시스템명령 혹은 sql명령) on 테이블명 from 계정;
   ```

9. 계정 삭제

   ```sql
   drop user 계정명 cascade;
   ```

10. 현재까지 진행 내용 저장하기

    ```sql
    commit;
    ```

11. 저장하기 전 바로 내용으로 되돌리기

    ```sql
    rollback;
    ```

12. 현재 연결된 계정 보기

    ```sql
    show user;
    ```

    

# Eclipse 연동하기

1. 하단에 Database Connections를 우클릭 한 후에 New를 누른다.
2. 저는 Oracle과 연동할 것이므로 Oracle를 선택하고 넘겨준다.
   ![](https://postfiles.pstatic.net/MjAyMDExMThfMTcy/MDAxNjA1Njg0NDk3NzA4.Ldw31pzrEXO34uZoS0sDyloqTgdcoj58AENJCa9e_RMg.2h0NH-KwcHCTER45agSr-AAXhUcH5j_0aszF6EEmnwwg.PNG.rgusqls/image.png?type=w773)
3. DataBase를 Oracle Tin Driver / Version을 11로 선택해준다.
   ![](https://postfiles.pstatic.net/MjAyMDExMThfMTQw/MDAxNjA1Njg0NjMzNzE0.c7UO28CcOrb8guz9yui7SJvxshdcd_wefIX7s96yLdog.69woN_6ABrfuV80QaVVddFUj2x1Ds_YUSeJAdchaRPgg.PNG.rgusqls/image.png?type=w773)

4. 

   ![](https://postfiles.pstatic.net/MjAyMDExMThfMTYz/MDAxNjA1Njg0Nzg3MDY2.Rf3SwXuqJ9mLRWew3DxccvxCJ3uzhWt3duoTj9HPLOsg.43bsD1CbjPi3OZUOIV0sn8-7eybJl0c_-zZ-bzICj9cg.PNG.rgusqls/image.png?type=w773)

JAR List를 클릭하면 ojdbc14.jar 가 들어가있는 것을 볼 수 있다.
이를 Clear All을 해준 후 Add JAR/Zip을 선택하여 jar파일을 선택한다.

5. 
   ![](https://postfiles.pstatic.net/MjAyMDExMThfNTYg/MDAxNjA1Njg0OTIzMTUw.gl1_iJHJEdwH2m2adwygcw67UlSWcJwWFyXcPCcUkC0g.4vNZaj4NfvnfI6Xu7A_F8FDt_rxu_f3aJMdbePg2z4gg.PNG.rgusqls/image.png?type=w773)

add JAR를 클릭하면 파일을 선택하는 창이 나온다.
여기서 C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 경로에 있는 ojdbc6.jar파일을 추가해준다.

6. 
   

![](https://postfiles.pstatic.net/MjAyMDExMThfMjQ4/MDAxNjA1Njg1MjUyNDM0.FO_1qJRu2cPM62MOPk08HNDgRRt4_iv6F2jIoxUvx0Ug.3iNs524X5RAbNGsgB9xepGh68BX9v2PqV62u_Z4TC5kg.PNG.rgusqls/image.png?type=w773)

위와 같이 입력해주면 연결이 된다.
**톰캣은 서버돌리는애 (ip주소:8787 밑에 우리가 프로젝트 war로 넣어주면 돌아가는 애)**
**오라클은 어떤 서버에서 돌린 건지 명시(ip주소:1521)**



# 이클립스 톰켓 연결하기

![](https://postfiles.pstatic.net/MjAyMDExMThfNjAg/MDAxNjA1Njg1NDYyODM1.fdqDposUihudZbWXhE75dJoU6SfPZ8Pn6I0nZBBUNpsg.uuQsqYoUrAgMMBm3fqNpwVCY_pXgTKgcrm9U2OrAGpgg.PNG.rgusqls/image.png?type=w773)

가장 하단에 Servers를 클릭하면 새로운 서버에 연결하는 링크가 나오며, 이를 클릭하면
New Server이라는 창이 뜬다.
**tomcat**이라고 쳐주고 내가 다운 받은 **tomcat은 9.0버전**이기 때문에 9.0을 선택하고 **Next**를 클릭한다.

![](https://postfiles.pstatic.net/MjAyMDExMThfMTcw/MDAxNjA1Njg1NjAwNzM3.ptOWRj6FTYjZnpJdJISLO5Q04anc-L4dOh-JfpRrKscg.gQU7NRjFj_queaG7AM0v4KKk9XqR5HDk29Yt-bAKV1Ug.PNG.rgusqls/image.png?type=w773)

그럼 이러한 창이 뜨는데, Browse...를 클릭하고 내가 톰켓을 다운받은 폴더를 선택해준다.
그 다음 Finish!!!!!!!!!!



# SpringBoot Start

- **SpringBoot란?**

  Spring Framework를 사용하는 project를 아주 간편하게 설정할 수 있는 Spring Framework의 sub project라고 할 수 있다.

  최소한의 초기 스프링 구성으로 가능한 한 빨리 시작하고 실행할 수 있도록 설계되었다.

  웹 컨테이너를 내장하고 있어 최소한의 설정으로 쉽게 웹 어플리케이션을 만들 수 있다.

- **SpringBoot의 장점**

  반복되는 개발환경 구축을 위한 코드 작성 등의 노력을 줄여주고 쉽고 빠르게 프로젝트를 설정할 수 있도록 도와준다.

  매우 빠르게 Spring 개발에 관해 광범위한 접근을 제공한다.

  프로젝트 환경 구축에서 큰 영역을 차지하는 비기능적인 기능들을 기본적으로 제공한다.
  (내장현 서버, 시큐리티, 측정, 상태 점검, 외부설정)



### SpringBoot는 Spring Initializr를 통하여 시작할 수 있고, 이클립스 내에서 할 수 있다.

1. **이클립스에서 SpringBoot 시작하기**

   ![](https://postfiles.pstatic.net/MjAyMDExMThfMjA0/MDAxNjA1NjkwMjY1MDk2.DIkil40ADVpbygTPKWjDFuZHIQ-jhp5hTUjUHi6400Eg.dtvbTNIMOdDBk8QX06NpmJ-hok5H4LhaaQHMwvIDf2sg.PNG.rgusqls/image.png?type=w773)

우선 이클립스에서 프로젝트를 생성한다.
**Other -> Spring Starter Project -> Next**



2. **Spring Setting을 해준다.**
   ![](https://postfiles.pstatic.net/MjAyMDExMThfMjcz/MDAxNjA1NjkwOTQzNDQ5.Ha506gQurgy7lEgln20cpdyo9CE7LfyzdyEDmYnbzSgg.QBcP25Z12YlHQM8xTpjIx_BL5rvXIpgl-Ae7zbrBIAog.PNG.rgusqls/image.png?type=w773)

**Name :** 프로젝트의 이름을 설정

**Type :** Maven으로 설정

**Java Version :** CMD에서 java -version을 치고 버전을 확인한 후, 버전에 맞게 선택

**Packaging :** jar로 설정

**Group :** 중복없이 설정

**Artifact :** 프로젝트의 Name을 설정하면 자동으로 설정이 잡힌다.

**Package :** rootPackage 설정 / Controller , Biz, Dao 등등 컴포넌트 스캔해줄 곳



3.  **의존성 추가하기**
   ![](https://postfiles.pstatic.net/MjAyMDExMThfNDcg/MDAxNjA1NjkxNzEyMjA3.1z5dpRpr6Ir8eY_oQSP3dH31WwZS7vKASd8oYAQMYJ8g.0hUcbwXVx_8GeHlhUYyobPkZmWwMuo2UMsgxoGmRJk4g.PNG.rgusqls/image.png?type=w773)

저는 위와같이 4가지의 디펜던시만 추가할 예정입니다.