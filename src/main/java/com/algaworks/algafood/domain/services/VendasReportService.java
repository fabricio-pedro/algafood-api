package com.algaworks.algafood.domain.services;

import com.algaworks.algafood.domain.repositories.filters.VendaDiariaFilter;

public interface VendasReportService {
   byte[] emitirVendasDiarias(VendaDiariaFilter filter,String timeOffset);
}
