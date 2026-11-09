package fssm.ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private static final String DEFAULT_ID = "CMD-001";
    private static final double DEFAULT_AMOUNT = 150.50;

    @BeforeEach
    void setUp() {
        order = new Order(DEFAULT_ID, DEFAULT_AMOUNT);
    }

    @Test
    @DisplayName("Vérifier l'initialisation correcte de l'identifiant, du montant et de l'état paid = false")
    void testOrderInitialization() {
        assertEquals(DEFAULT_ID, order.getId(), "L'ID de la commande doit correspondre à celui passé au constructeur");
        assertEquals(DEFAULT_AMOUNT, order.getAmount(), 0.001, "Le montant doit être égal au montant initialisé");
        assertFalse(order.isPaid(), "Une nouvelle commande doit impérativement avoir l'état paid à false");
    }

    @Test
    @DisplayName("Vérifier que setPaid(true) modifie correctement l'état à true")
    void testSetPaidTrue() {
        order.setPaid(true);
        assertTrue(order.isPaid(), "L'état de paiement de la commande devrait être true après appel à setPaid(true)");
    }

    @Test
    @DisplayName("Vérifier que setPaid(false) maintient ou remet l'état à false")
    void testSetPaidFalse() {
        order.setPaid(false);
        assertFalse(order.isPaid(), "L'état de paiement doit rester false si on lui assigne false");
    }
}
