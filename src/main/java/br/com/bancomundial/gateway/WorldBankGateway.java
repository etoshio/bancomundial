package br.com.bancomundial.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "WorldBankGateway", url = "${app.host}")
public interface WorldBankGateway {

    @GetMapping("/v2/country/{country}/indicator/SI.POV.DDAY")
    List<Object> getWorldBank(@PathVariable String country, @RequestParam("format") String json, @RequestParam("per_page") Integer perPage);
}
