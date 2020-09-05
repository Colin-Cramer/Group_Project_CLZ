create database if not exists social_media_app;

use social_media_app;

drop table if exists comments;
drop table if exists posts;
drop table if exists users;

create table users (
	username varchar(20) not null,
	password varchar(20) not null,
	email varchar(30) not null, 
	first_name varchar(20),
	last_name varchar(20),
	primary key (username)
);

create table posts (
	post_title varchar(40) not null,
	username varchar(20) NOT NULL,
	post_content text not null,
	post_created_on timestamp default current_timestamp,
	primary key (post_title),	
	foreign key (username) references users (username)
);

create table comments (
	comment_title varchar(40) not null,
	username varchar(20) NOT NULL,
	comment_content text not null,
	comment_created_on timestamp,
	primary key (comment_title),
	foreign key (username) references posts(username)
);

