import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompteBancariTest {

    private CompteBancari compte;

    @BeforeEach
    void setUp() {
        compte = new CompteBancari("Maria Garcia", "ES1234567890123456789012", 1000.0);
    }

    // ==================== TESTS DE CREACIÓ ====================

    @Test
    void testCreacioCorrecta() {
        assertEquals("Maria Garcia", compte.getTitular());
        assertEquals("ES1234567890123456789012", compte.getIban());
        assertEquals(1000.0, compte.getSaldo(), 0.001);
    }

    @Test
    void testErrorTitularBuit() {
        assertThrows(IllegalArgumentException.class, () -> 
            new CompteBancari("", "ES1234567890123456789012", 500.0));
    }

    @Test
    void testErrorTitularNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new CompteBancari(null, "ES1234567890123456789012", 500.0));
    }

    @Test
    void testErrorIbanBuit() {
        assertThrows(IllegalArgumentException.class, () -> 
            new CompteBancari("Maria Garcia", "", 500.0));
    }

    @Test
    void testErrorSaldoNegatiu() {
        assertThrows(IllegalArgumentException.class, () -> 
            new CompteBancari("Maria Garcia", "ES1234567890123456789012", -100.0));
    }

    // ==================== TESTS D'INGRESSOS ====================

    @Test
    void testIngressarQuantitatPositiva() {
        compte.ingressar(250.50);
        assertEquals(1250.50, compte.getSaldo(), 0.001);
    }

    @Test
    void testErrorIngressarQuantitatZero() {
        assertThrows(IllegalArgumentException.class, () -> compte.ingressar(0));
    }

    @Test
    void testErrorIngressarQuantitatNegativa() {
        assertThrows(IllegalArgumentException.class, () -> compte.ingressar(-50));
    }

    // ==================== TESTS DE RETIRADES ====================

    @Test
    void testRetirarQuantitatCorrecta() {
        compte.retirar(300.0);
        assertEquals(700.0, compte.getSaldo(), 0.001);
    }

    @Test
    void testErrorRetirarMesQueSaldo() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(1500.0));
    }

    @Test
    void testErrorRetirarQuantitatZero() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(0));
    }

    @Test
    void testErrorRetirarQuantitatNegativa() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(-100));
    }
}
