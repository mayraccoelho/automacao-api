package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente julio, bola;
    Conta contaJulio, contaBola;

    @BeforeEach
    void setUp() {
        julio = new Cliente("Julio Cesar", "12343212343", "123456789");
        bola = new Cliente("Bola bolina", "1234123123", "213124455");

        contaJulio = new Conta("236", "157", 7000.00, julio);
        contaBola = new Conta("237", "123", 1.00, bola);
    }

    @Test
    public void realizarTransacao() {
        contaJulio.realizarTransferencia(1.00, contaBola);

        assertEquals(6999.00, contaJulio.getSaldo());
        assertEquals(2.00, contaBola.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida() {
        Boolean transferencia = contaJulio.realizarTransferencia(9000.00, contaBola);

        assertFalse(transferencia, "A transferência não foi realizada!");
    }

    @Test
    public void validarProprietario() {
        assertEquals(julio, contaJulio.getProprietario());
    }

    @Test
    public void validarAgencia() {
        assertEquals("236", contaJulio.getAgencia());
    }

    @Test
    public void validarConta() {
        assertEquals("157", contaJulio.getNumeroConta());
    }

    @Test
    public void validarRg() {
        assertEquals("123456789", julio.getRg());
    }

    @Test
    public void validarCpf() {
        assertEquals("12343212343", julio.getCpf());
    }

    @Test
    public void validarNome() {
        assertEquals("Julio Cesar", julio.getNome());
    }
}