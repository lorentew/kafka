package br.com.wlorente.kafkaline.ibgewrapper.gateway.feign;

import br.com.wlorente.kafkaline.ibgewrapper.gateway.json.CidadeJson;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CidadeClient {

    // https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios

    @RequestLine("GET /api/v1/localidades/estados/{UF}/municipios")
    List<CidadeJson> get(@Param("UF") String uf);

}
