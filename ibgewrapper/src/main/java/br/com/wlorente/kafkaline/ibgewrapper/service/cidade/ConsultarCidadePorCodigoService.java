package br.com.wlorente.kafkaline.ibgewrapper.service.cidade;

import br.com.wlorente.kafkaline.ibgewrapper.gateway.feign.CidadeClient;
import br.com.wlorente.kafkaline.ibgewrapper.gateway.json.CidadeJson;
import feign.Feign;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import feign.gson.GsonDecoder;


import java.util.List;

@Service

public class ConsultarCidadePorCodigoService {

    @Cacheable(value = "cidade")
    public List<CidadeJson> execute(String estado){

        long tempoInicial = System.currentTimeMillis();

        CidadeClient cidadeClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(CidadeClient.class, "https://servicodados.ibge.gov.br");

        List<CidadeJson> list =  cidadeClient.get(estado);

        System.out.printf("Tempo de execucao: %.3f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
        return list;
    }
}