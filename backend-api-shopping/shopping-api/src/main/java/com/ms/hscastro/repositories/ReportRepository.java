package com.ms.hscastro.repositories;

import java.util.Date;
import java.util.List;

import com.ms.hscastro.dto.ShopReportDTO;
import com.ms.hscastro.entities.Shop;

public interface ReportRepository {

	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
