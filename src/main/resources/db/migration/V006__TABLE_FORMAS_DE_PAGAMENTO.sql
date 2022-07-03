CREATE table formasDePagamento(
  id bigint not null auto_increment,
  descricao varchar(100) not null,
  primary key(id)


) engine=InnoDB default charset=utf8;