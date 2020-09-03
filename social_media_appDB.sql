create database if not exists social_media_app;

use social_media_app;

drop table if exists comments;
drop table if exists posts;
drop table if exists users;

create table users (
	id int(11) not null auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
	email varchar(30) not null, 
	first_name varchar(20),
	last_name varchar(20),
	primary key (id)
);

create table posts (
	id int(11) not null auto_increment,
    user_id int(11) not null,
	username varchar(20) not null,
	post_content text not null,
	post_created_on timestamp not null,
	primary key (id),	
	foreign key (user_id) references users (id)
);

create table comments (
	id int(11) not null auto_increment,
    post_id int(11) not null,
	username varchar(20) not null,
	comment_content text not null,
	comment_created_on timestamp not null,
	primary key (id),
	foreign key (post_id) references posts(id)
);