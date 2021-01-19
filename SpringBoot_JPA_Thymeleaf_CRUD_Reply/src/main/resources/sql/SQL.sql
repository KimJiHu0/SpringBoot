drop table boardlist;

create table boardlist(
	boardno int unsigned auto_increment,
	boardname varchar(50) not null,
	boardtitle varchar(100) not null,
	boardcontent varchar(1000) not null,
	constraint boardlist_boardno_pk primary key(boardno)
) default charset=utf8;

insert into boardlist(boardname, boardtitle, boardcontent) values('관리자', '제목', '내용');

select * from boardlist;

-- 해당 글에 대한 댓글들을 가져오기 위해서는, boardno를 외래키로 받아와야합니다.

drop table reply;
create table boardreply(
	replyno int unsigned auto_increment, -- 댓글 번호
	replywriter varchar(100) not null, -- 댓글 작성자
	replycontent varchar(1000) not null, -- 댓글 내용
	replydate date not null, -- 댓글 작성 날짜
	boardno int unsigned, -- 게시글 번호
	primary key(replyno), -- 댓글 번호는 pk이며
	foreign key(boardno) references boardlist(boardno) on delete cascade -- 외래키입니다.
) default charset=utf8;	


-- 테스트를 위해서 2개만 추가했습니다.
insert into boardreply(replywriter, replycontent, replydate, boardno) values('회원', '댓글내용', now(), 5);

SELECT * FROM BOARDREPLY WHERE BOARDNO = BOARDNO;

-- 해당 글에 대한 댓글 출력하는 쿼리문
SELECT R.REPLYNO, R.REPLYWRITER, R.REPLYCONTENT, R.REPLYDATE, R.BOARDNO
FROM BOARDREPLY R JOIN BOARDLIST L
ON R.BOARDNO = L.BOARDNO WHERE R.BOARDNO = 3;

select r.replyno, r.replywriter, r.replycontent, r.replydate, r.boardno from boardreply r join boardlist l on r.boardno = l.boardno where r.boardno = 4;


INSERT INTO BOARDREPLY(REPLYWRITER, REPLYCONTENT, REPLYDATE, BOARDNO) VALUES('작성해볼게요.', '내용입니당.', now(), 3);