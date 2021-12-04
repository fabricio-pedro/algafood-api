insert into cozinha(id,nome) values(1,'tailandesa');
insert into cozinha(id,nome) values(2,'chinesa');
insert into cozinha(id,nome) values(3,'italiana');

insert into restaurante(nome,taxa_frete,cozinha_id) values('Xang ji',9.50,1);
insert into restaurante(nome,taxa_frete,cozinha_id) values('Valle tudi',10.0,3);

insert into produto(nome,descricao,preco,ativo,restaurante_id) values('macarrao','contem macarrao vermelho com azeitonas',10.45,true,1); 

insert into estado(id,nome) values(1,'Minas Gerais');
insert into estado(id,nome) values(2,'Sao Paulo');

insert into cidade(nome,estado_id) values('Patrocinio',1);
insert into cidade(nome,estado_id) values('Uberlandia',1);
insert into cidade(nome,estado_id) values('Uberaba',1);


