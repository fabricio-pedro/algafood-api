package com.algaworks.algafood.domain.services;

import java.util.List;

import com.algaworks.algafood.domain.model.dto.VendaDiaria;
import com.algaworks.algafood.domain.repositories.filters.VendaDiariaFilter;

public interface VendaQueryService {
	List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);
}
