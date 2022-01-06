package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

    @Dado("que tenha um payload valido da API de Login")
    public void queTenhaUmPayloadValidoDaAPIDeLogin() {

    }
    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {

    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {

    }

    @Dado("que tenha um payload da API de Login com as seguintes informacoes")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformacoes(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
