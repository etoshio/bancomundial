package br.com.bancomundial.service;

import br.com.bancomundial.data.exception.GatewayException;
import br.com.bancomundial.data.response.IndicatorResponse;
import br.com.bancomundial.gateway.WorldBankGateway;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorldBankService {

    @Autowired
    WorldBankGateway gateway;
    private static String JSON = "json";
    private static Integer PER_PAGE = 200;

    public List<IndicatorResponse> getWorldBank(String countryCode) {
        try {
            List<Object> objectList = gateway.getWorldBank(countryCode, JSON, PER_PAGE);
            if (objectList != null && objectList.size() > 1) {
                var objectMapper = new ObjectMapper();
                var responses = objectMapper.convertValue(objectList.get(1),
                        new TypeReference<List<IndicatorResponse>>() {
                        });
                return responses;
            }
            return null;
        } catch (Exception e) {
            throw new GatewayException(e);
        }
    }
}
