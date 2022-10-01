package br.com.bancomundial.controller;

import br.com.bancomundial.data.response.IndicatorResponse;
import br.com.bancomundial.service.WorldBankService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Controller para buscar os dados por código do país
 *
 */

@RestController
@Api(value = "WorldBankController", tags = { "World Bank" })
@SwaggerDefinition(tags = { @Tag(name = "World Bank", description = "Banco Mundial") })
@CrossOrigin(origins = "*")
public class WorldBankController extends BaseController {

    @Autowired
    WorldBankService service;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com sucesso."),
            @ApiResponse(code = 404, message = "Nenhum resultado encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @ApiOperation(value = "Busca os índices por país")
    @RequestMapping(value = "/worldbank/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<IndicatorResponse>> worldbank(@PathVariable String countryCode) {
        var response = service.getWorldBank(countryCode);
        if(ObjectUtils.isEmpty(response)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
