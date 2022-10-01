package br.com.bancomundial.service;

import br.com.bancomundial.data.exception.GatewayException;
import br.com.bancomundial.data.response.BaseResponse;
import br.com.bancomundial.data.response.IndicatorResponse;
import br.com.bancomundial.gateway.WorldBankGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WorldBankServiceTest {
    WorldBankService service;

    @Mock
    WorldBankGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = mock(WorldBankGateway.class);
        service = new WorldBankService(gateway);
    }

    @Test
    void successGetWorldBank() {
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        List<IndicatorResponse> responses = new ArrayList<>();
        responses.add(IndicatorResponse.builder().indicator(new BaseResponse()).build());
        objectList.add(responses);

        when(gateway.getWorldBank(any(), any(), any())).thenReturn(objectList);
        List<IndicatorResponse> result = service.getWorldBank("bra");
        Assertions.assertNotNull(result);
    }

    @Test
    void errorWorldBank() {
        when(gateway.getWorldBank(any(), any(), any())).thenThrow(new GatewayException("erro"));

        assertThrows(GatewayException.class, () -> service.getWorldBank("bra"));
    }
}