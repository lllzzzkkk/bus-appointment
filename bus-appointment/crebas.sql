/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/18 13:40:21                           */
/*==============================================================*/


drop table if exists appointment;

drop table if exists appointment_history;

drop table if exists remainder_info;

drop table if exists route;

drop table if exists route_station;

drop table if exists schedule;

drop table if exists schedule_station_time;

drop table if exists station;

drop table if exists vehicle;

drop table if exists vehicle_busnum;

drop table if exists vehicle_busnum_history;

drop table if exists vehicle_configuration;

drop table if exists vehicle_remainder;

/*==============================================================*/
/* Table: appointment                                           */
/*==============================================================*/
create table appointment
(
  id                   bigint not null auto_increment,
  up_id                bigint,
  down_id              bigint,
  ride_date            date,
  directed             bool,
  vehicle_num          int,
  seat_num             int,
  status               int,
  classification       bool,
  qcode                varchar(50),
  operator_time        datetime,
  user_id              bigint,
  gps_id               bigint,
  primary key (id)
);

/*==============================================================*/
/* Table: appointment_history                                   */
/*==============================================================*/
create table appointment_history
(
  id                   bigint not null,
  up_id                bigint,
  down_id              bigint,
  ride_date            date,
  directed             bool,
  vehicle_num          int,
  seat_num             int,
  status               int,
  classification       bool,
  qcode                varchar(50),
  operator_time        datetime,
  user_id              bigint,
  gps_id               bigint,
  primary key (id)
);

/*==============================================================*/
/* Table: remainder_info                                        */
/*==============================================================*/
create table remainder_info
(
  id                   bigint not null auto_increment,
  schedule_id          bigint,
  count                int,
  remainder_date       date,
  showed               bool,
  primary key (id)
);

/*==============================================================*/
/* Table: route                                                 */
/*==============================================================*/
create table route
(
  id                   bigint not null auto_increment,
  name                 varchar(30),
  disabled             bool,
  direction            bool,
  primary key (id)
);

/*==============================================================*/
/* Table: route_station                                         */
/*==============================================================*/
create table route_station
(
  id                   bigint not null auto_increment,
  route_id             bigint,
  station_id           bigint,
  order_index          int,
  primary key (id)
);

/*==============================================================*/
/* Table: schedule                                              */
/*==============================================================*/
create table schedule
(
  id                   bigint not null auto_increment,
  route_id             bigint,
  start_time           datetime,
  week                 char(7),
  primary key (id)
);

/*==============================================================*/
/* Table: schedule_station_time                                 */
/*==============================================================*/
create table schedule_station_time
(
  id                   bigint not null auto_increment,
  schedule_id          bigint,
  station_id           bigint,
  ride_time            time,
  order_index          int,
  primary key (id)
);

/*==============================================================*/
/* Table: station                                               */
/*==============================================================*/
create table station
(
  id                   bigint not null auto_increment,
  name                 varchar(20),
  description          varchar(100),
  disabled             bool,
  area                 bool,
  primary key (id)
);

/*==============================================================*/
/* Table: vehicle                                               */
/*==============================================================*/
create table vehicle
(
  id                   bigint not null auto_increment,
  vehicle_configuration bigint,
  plate_number         varchar(20),
  device_id            varchar(32),
  primary key (id)
);

/*==============================================================*/
/* Table: vehicle_busnum                                        */
/*==============================================================*/
create table vehicle_busnum
(
  id                   bigint not null auto_increment,
  schedule_station_time_id bigint,
  vehicle_id           bigint,
  busnum               int,
  directed             bool,
  startDate            date,
  primary key (id)
);

/*==============================================================*/
/* Table: vehicle_busnum_history                                */
/*==============================================================*/
create table vehicle_busnum_history
(
  id                   bigint not null,
  schedule_station_time_id bigint,
  vehicle_id           bigint,
  busnum               int,
  directed             bool,
  startDate            date,
  gps_path             varchar(30),
  primary key (id)
);

/*==============================================================*/
/* Table: vehicle_configuration                                 */
/*==============================================================*/
create table vehicle_configuration
(
  id                   bigint not null auto_increment,
  number               int,
  description          varchar(50),
  primary key (id)
);

/*==============================================================*/
/* Table: vehicle_remainder                                     */
/*==============================================================*/
create table vehicle_remainder
(
  id                   bigint not null auto_increment,
  vehicle_busnum_id    bigint,
  count                int,
  primary key (id)
);

alter table appointment add constraint FK_Reference_11 foreign key (up_id)
references schedule_station_time (id) on delete restrict on update restrict;

alter table appointment add constraint FK_Reference_12 foreign key (down_id)
references schedule_station_time (id) on delete restrict on update restrict;

alter table remainder_info add constraint FK_Reference_10 foreign key (schedule_id)
references schedule (id) on delete restrict on update restrict;

alter table route_station add constraint FK_Reference_1 foreign key (route_id)
references route (id) on delete restrict on update restrict;

alter table route_station add constraint FK_Reference_2 foreign key (station_id)
references station (id) on delete restrict on update restrict;

alter table schedule add constraint FK_Reference_3 foreign key (route_id)
references route (id) on delete restrict on update restrict;

alter table schedule_station_time add constraint FK_Reference_4 foreign key (schedule_id)
references schedule (id) on delete restrict on update restrict;

alter table schedule_station_time add constraint FK_Reference_5 foreign key (station_id)
references station (id) on delete restrict on update restrict;

alter table vehicle add constraint FK_Reference_8 foreign key (vehicle_configuration)
references vehicle_configuration (id) on delete restrict on update restrict;

alter table vehicle_busnum add constraint FK_Reference_6 foreign key (schedule_station_time_id)
references schedule_station_time (id) on delete restrict on update restrict;

alter table vehicle_busnum add constraint FK_Reference_7 foreign key (vehicle_id)
references vehicle (id) on delete restrict on update restrict;

alter table vehicle_remainder add constraint FK_Reference_9 foreign key (vehicle_busnum_id)
references vehicle_busnum (id) on delete restrict on update restrict;

