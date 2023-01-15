Create table restaurante_responsavel(
usuario_id bigint not null,
restaurante_id bigint not null,
constraint Fk_responsavel_id foreign key (usuario_id) 
references usuario (id),
constraint fk_restaurante_p_id foreign key (restaurante_id)
references restaurante(id)
) engine=InnoDB charset=utf8mb4;

