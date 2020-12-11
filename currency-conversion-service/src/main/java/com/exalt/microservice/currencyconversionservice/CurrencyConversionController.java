package com.exalt.microservice.currencyconversionservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    CurrancyConvesionBean ConvertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrancyConvesionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                                                                CurrancyConvesionBean.class, uriVariables);
        CurrancyConvesionBean responseEntityBody = responseEntity.getBody();
          return new CurrancyConvesionBean(responseEntityBody.getId(),from,to,responseEntityBody.getConversionMultipe(),
                quantity,quantity.multiply(responseEntityBody.getConversionMultipe()),
                responseEntityBody.getPort());

    }
    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}/v2")
    CurrancyConvesionBean ConvertCurrencyv2(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {

        CurrancyConvesionBean  response = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);
        return new CurrancyConvesionBean(response.getId(),from,to,response.getConversionMultipe(),
                quantity,quantity.multiply(response.getConversionMultipe()),
                response.getPort());

    }

}
