CREATE table forma_pagamento (
id bigint not null auto_increment, 
descricao varchar(120) not null, 
primary key (id)) engine=InnoDB charset=utf8mb4;

CREATE table grupo (
id bigint not null auto_increment,
nome varchar(255) not null,
primary key (id)) engine=InnoDB charset=utf8mb4;

CREATE table permissao (
id bigint not null auto_increment,
descricao varchar(100) not null,
nome varchar(100) not null,
primary key (id)) engine=InnoDB charset=utf8mb4;

CREATE table grupo_permissao (
grupo_id bigint not null,
permissao_id bigint not null,
constraint Fk_permissao_id foreign key (permissao_id) 
references permissao (id),
constraint fk_grupo_id foreign key (grupo_id)
references grupo(id)
) engine=InnoDB charset=utf8mb4;

CREATE table usuario (
id bigint not null auto_increment, 
data_cadastro datetime(6),
email varchar(255) not null, 
nome varchar(255) not null,
senha varchar(255) not null,
primary key (id)) engine=InnoDB charset=utf8mb4;

CREATE table usuario_grupo (
usuario_id bigint not null, 
grupo_id bigint not null,
constraint fk_usuario_id foreign key(usuario_id)
references usuario(id),
constraint fk_grupo_u_id foreign key(grupo_id)
references grupo(id) 
) engine=InnoDB charset=utf8mb4;

Create table restaurante (
	id bigint not null auto_increment,
	cozinha_id bigint not null,
	nome varchar(80) not null,
	taxa_frete decimal(10,2) not null,
	data_atualizacao datetime not null,
	data_cadastro datetime not null,
	
	endereco_cidade_id bigint,
	endereco_cep varchar(9),
	endereco_logradouro varchar(100),
	endereco_numero varchar(20),
	endereco_complemento varchar(60),
	endereco_bairro varchar(60),
	
	constraint fk_cidade_id foreign key (endereco_cidade_id)
    references cidade(id),
	constraint fk_cozinha_id foreign key (cozinha_id)
    references cozinha(id),
	primary key (id)
	
)engine=InnoDB charset=utf8mb4;

CREATE table produto (
id bigint not null auto_increment,
ativo bit not null,
descricao varchar(255) not null,
nome varchar(255) not null,
preco decimal(12,2) not null,
restaurante_id bigint,
primary key (id),
constraint fk_restaurante_id foreign key(restaurante_id)
references restaurante(id)
)engine=InnoDB charset=utf8mb4;

CREATE table pedido (id bigint not null auto_increment,
data_cancelamento datetime(6),
data_confirmacao datetime(6) not null,
data_criacao datetime(6) not null, 
data_entrega datetime(6) not null, 
endereco_bairro varchar(120),
endereco_cep varchar(16) not null,
endereco_complemento varchar(120),
endereco_logradouro varchar(120) not null, 
endereco_numero varchar(18) not null,
status varchar(50),
sub_total decimal(12,2), 
taxa_frete decimal(12,2) not null,
valor_total decimal(12,2), 
endereco_cidade_id bigint not null,
forma_pagamento_id bigint not null,
usuario_cliente_id bigint not null,
restaurante_id bigint not null,
primary key (id),
constraint fk_endereco_entrega_id foreign key(endereco_cidade_id)
references cidade(id),
constraint fk_forma_pagamento_id foreign key(forma_pagamento_id)
references forma_pagamento(id),
constraint fk_restaurantep_id foreign key(restaurante_id)
references restaurante(id)
) engine=InnoDB charset=utf8mb4;
Create table restaurante_forma_pagamento (
	restaurante_id bigint not null,
	forma_pagamento_id bigint not null,
	
	primary key (restaurante_id, forma_pagamento_id)
) engine=InnoDB default charset=utf8mb4;

