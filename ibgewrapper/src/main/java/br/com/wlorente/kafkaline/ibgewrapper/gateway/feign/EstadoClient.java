package br.com.wlorente.kafkaline.ibgewrapper.gateway.feign;

import br.com.wlorente.kafkaline.ibgewrapper.gateway.json.EstadoJson;
import feign.RequestLine;

import java.util.List;

public interface EstadoClient {

    //http://servicodados.ibge.gov.br/api/v1/localidades/estados

    @RequestLine("GET /api/v1/localidades/estados")
    List<EstadoJson> get();


}
