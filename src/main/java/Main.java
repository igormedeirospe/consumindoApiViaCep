import modelo.Endereco;
import servicos.ViaCepServico;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        ViaCepServico viaCepServico = new ViaCepServico();
        try {
            Endereco endereco = viaCepServico.getEndereco("04801-010");
            System.out.println(endereco);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
