select * from boardlist;
select * from boardreply;

create table boardmember(
	memberidx int unsigned auto_increment,
	memberid varchar(100) not null,
	memberpw varchar(100) not null,
	membername varchar(100) not null,
	memberregdate date not null,
	primary key(memberidx)
)default charset=utf8;

insert into boardmember(memberid, memberpw, membername, memberregdate) values('admin', 'admin1234', '관리자', now());

select * from boardmember;

SELECT COUNT(*) FROM BOARDMEMBER WHERE MEMBERID = 'admin';