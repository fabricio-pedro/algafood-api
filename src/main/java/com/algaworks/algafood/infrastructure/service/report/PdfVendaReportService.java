package com.algaworks.algafood.infrastructure.service.report;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.repositories.filters.VendaDiariaFilter;
import com.algaworks.algafood.domain.services.VendaQueryService;
import com.algaworks.algafood.domain.services.VendasReportService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PdfVendaReportService implements VendasReportService {

	@Autowired
	private VendaQueryService vendaQueryService;
	
	@Override
	public byte[] emitirVendasDiarias(VendaDiariaFilter filter, String timeOffset) {
		try {
		var inputStream=this.getClass().getResourceAsStream("/relatorios/vendas-diarias.jasper");
		Map<String, Object> parametros=new HashMap<>();
		parametros.put("REPORT_LOCALE", new Locale("pt","BR"));
	    var vendasDiarias=vendaQueryService.consultarVendasDiarias(filter, timeOffset);
		var datasource=new JRBeanCollectionDataSource(vendasDiarias);
		var jasperPrint =JasperFillManager.fillReport(inputStream, parametros,datasource);
		return JasperExportManager.exportReportToPdf(jasperPrint);
		}catch(Exception e) {
			throw new ReportException("Nao foi possivel emitir o relatorio",e);
		}
   }

}
