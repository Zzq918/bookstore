/**
*author:zzq
*date:2017年5月
*descript:数据库设计语句
*
*/
drop table if exists admin;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   a_id                 varchar(32) not null,
   mName                varchar(20),
   name                 varchar(20),
   phone                varchar(20),
   headImg              varchar(100),
   uName                varchar(20),
   passWord             varchar(20),
   balance              int,
   primary key (a_id)
);


drop table if exists book;

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
   bId                  varchar(32) not null,
   a_id                 varchar(32),
   bname                varchar(40),
   author               varchar(30),
   bPrice               int,
   bImg                 varchar(100),
   number               int,
   sale                 int,
   introduce            varchar(200),
   primary key (bId)
);

alter table book add constraint FK_admin_book foreign key (a_id)
      references admin (a_id) on delete restrict on update restrict;
drop table if exists userOrder;

/*==============================================================*/
/* Table: userOrder                                             */
/*==============================================================*/
create table userOrder
(
   oId                  varchar(32) not null,
   uId                  varchar(32),
   bId                  varchar(32),
   bname                varchar(40),
   bPrice               int,
   state                varchar(1),
   address              varchar(100),
   relation             varchar(32),
   primary key (oId)
);

alter table userOrder add constraint FK_bookOrder foreign key (bId)
      references book (bId) on delete restrict on update restrict;

alter table userOrder add constraint FK_userOrder foreign key (uId)
      references customer (uId) on delete restrict on update restrict;

      drop table if exists customer;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   uId                  varchar(32) not null,
   uImg                 varchar(100),
   uName                varchar(20),
   uPassWord            varchar(20),
   uCount               int,
   uPhone               varchar(20),
   name                 varchar(20),
   primary key (uId)
);
