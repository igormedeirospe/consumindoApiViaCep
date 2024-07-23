package servicos;

import com.google.gson.Gson;
import modelo.Endereco;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//essa classe terá um metodo responsavel por fazer a requisição ao webservice da via cep;
public class ViaCepServico {
    public Endereco getEndereco(String cep) throws IOException {
        Endereco endereco = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null){
               String result = EntityUtils.toString(entity);
               //converter essa resposta num objeto de tipo endereço
                Gson gson = new Gson();
                endereco = gson.fromJson(result,Endereco.class);
            }
        }

        return endereco;
    }

}
