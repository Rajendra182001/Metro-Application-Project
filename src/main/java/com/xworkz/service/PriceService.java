package com.xworkz.service;

import com.xworkz.dto.PriceDto;

import java.util.List;

public interface PriceService {

    public boolean savePriceFromUi(PriceDto priceDto);

    public PriceDto findBySourceAndDestination(String source,String destination);

     List<PriceDto> readPrice();

   public   PriceDto   findPrice(Integer price);
   public PriceDto findPriceBySourceAndDestination(Integer price,String source,String destination);

    PriceDto findById(Integer priceId);
}
