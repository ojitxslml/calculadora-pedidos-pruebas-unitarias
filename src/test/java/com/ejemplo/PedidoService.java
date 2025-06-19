package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
    PedidoService service = new PedidoService(new DescuentoRepository());

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, "", false);
        assertEquals(110.0, total);
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total); // 100 - 10% + 20
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, "PROMO10", false);
        assertEquals(190.0, total);
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, "", true);
        assertEquals(170.0, total);
    }
}
