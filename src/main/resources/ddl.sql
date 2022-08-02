CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
insert into cozinha(id,nome) values(1,'tailandesa')
insert into cozinha(id,nome) values(2,'chinesa')
insert into cozinha(id,nome) values(3,'italiana')
insert into cozinha(id,nome) values(4,'brasileira')
insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3)
insert into restaurante(nome,taxa_frete,cozinha_id) values('Cozinha mineira',10.0,4)
insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1)
insert into estado(id,nome) values(1,'Minas Gerais')
insert into estado(id,nome) values(2,'Sao Paulo')
insert into cidade(nome,estado_id) values('Patrocinio',1)
insert into cidade(nome,estado_id) values('Uberlandia',1)
insert into cidade(nome,estado_id) values('Uberaba',1)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
CREATE table cidade (id bigint not null auto_increment, nome varchar(100) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
CREATE table cozinha (id bigint not null auto_increment, nome varchar(100), primary key (id)) engine=InnoDB
CREATE table estado (id bigint not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table forma_pagamento (id bigint not null, descricao varchar(120) not null, primary key (id)) engine=InnoDB
CREATE table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
CREATE table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
CREATE table item_pedido (id bigint not null auto_increment, observacao varchar(125), preco_total decimal(19,2), preco_unitario decimal(19,2), quantidade integer not null, pedido_id bigint not null, produto_id bigint not null, primary key (id)) engine=InnoDB
CREATE table pedido (id bigint not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6) not null, data_criacao datetime(6), data_entrega datetime(6) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status varchar(255), sub_total decimal(19,2), taxa_frete decimal(19,2) not null, valor_total decimal(19,2), endereco_cidade_id bigint, forma_pagamento_id bigint not null, usuario_cliente_id bigint not null, primary key (id)) engine=InnoDB
CREATE table permissao (id bigint not null auto_increment, descricao varchar(100) not null, nome varchar(100) not null, primary key (id)) engine=InnoDB
CREATE table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurante (id bigint not null auto_increment, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(150), taxa_frete decimal(19,2), cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
CREATE table restaurantes_formas_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
CREATE table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
CREATE table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurantes_formas_pagamento add constraint FKew2y9o7p7lrq7k5fjny8adubs foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurantes_formas_pagamento add constraint FKgi9ifso8spt23l0jlc1txq4w8 foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
