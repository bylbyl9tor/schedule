create database scheduledb;
use scheduledb;
/* НЕ ХВАТАЕТ ТАБЛИЦЫ ГРУППЫ, РАСПИСАНИЕ, ЛИНКОВОЧНОЙ ТАБЛИЦЫ РАСПИСАНИЕ&ГРУППЫ */
create table subject_name_table( 
id int auto_increment primary key,
subject_name varchar(45) not null);

create table lesson_type_table( 
id int auto_increment primary key,
lesson_type varchar(25) not null);

create table teacher_table(
id int auto_increment primary key,
teacher varchar(50) not null);

create table classroom_table(
id int auto_increment primary key,
classroom_number varchar(7));

create table faculty_table(
id int auto_increment primary key,
faculty_name varchar(45));

create table specialty_table(
id int auto_increment,
specialty_name varchar(30),
id_faculty int,
primary key(id,id_faculty),
foreign key (id_faculty) references faculty_table(id));/*связь один ко многим для таблиц faculty_table&specialty_table */

create table teacher_subject_name(  /*связь многие ко многим для таблиц teacher&subjet */
id_teacher int not null,
id_subject int not null,
primary key (id_teacher , id_subject),
foreign key (id_teacher ) references teacher_table(id),
foreign key (id_subject ) references subject_name_table(id));

create table specialty_subject(  /*связь многие ко многим для таблиц specialty&subjet */
id_specialty int not null,
id_subject int not null,
primary key (id_specialty , id_subject),
foreign key (id_specialty ) references specialty_table(id),
foreign key (id_subject ) references subject_name_table(id));

create table group_table(
id int auto_increment ,
group_name varchar(12),
id_specialty int,
id_specialty_faculty int,
primary key (id,id_specialty,id_specialty_faculty),
foreign key(id_specialty,id_specialty_faculty) references specialty_table(id,id_faculty));/*связь один ко многим для таблиц specialty_table&group_table */

create table schedule_table(
id int auto_increment ,
id_teacher int not null,
id_lesson_type int not null,
id_classroom int not null,
primary key(id, id_teacher, id_classroom, id_lesson_type),
foreign key (id_teacher) references teacher_table(id),
foreign key (id_classroom) references classroom_table(id),
foreign key (id_lesson_type) references lesson_type_table(id));

create table schedule_group(
id_schedule int not null,
id_teacher int not null,
id_classroom int not null,
id_lesson_type int not null,
id_group int not null,
id_group_specialty int not null,
id_group_specialty_faculty int not null,
primary key (id_schedule, id_teacher, id_classroom, id_lesson_type, id_group, id_group_specialty, id_group_specialty_faculty),
foreign key (id_schedule, id_teacher, id_classroom, id_lesson_type) references schedule_table(id, id_teacher, id_classroom, id_lesson_type),
foreign key (id_group, id_group_specialty, id_group_specialty_faculty) references group_table(id,id_specialty,id_specialty_faculty));
