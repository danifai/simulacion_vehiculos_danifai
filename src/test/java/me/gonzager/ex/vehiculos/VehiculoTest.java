package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {

        Vehiculo vehiculo = new Vehiculo(3.0);

        vehiculo.retrocederTipoConduccion();
        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();
        vehiculo.retrocederTipoConduccion();

        assertEquals(150, vehiculo.getVelocidadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {

        Vehiculo vehiculo = new Vehiculo(25.0);
        
        // Cambiar una vez el tipo de conducción (a Estándar)
        vehiculo.avanzarTipoConduccion();
        
        vehiculo.desplazar(200.0);
        
        assertEquals(200.0, vehiculo.getKilometraje());
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {

        var vehiculo = new Vehiculo(13.0);

        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();

        assertThrows(
                RuntimeException.class,
                () -> {
                    vehiculo.desplazar(75.0);
                },
                "Combustible insuficiente, solo pude recorrer 65 del total de 75.0 kilometros.");
        assertEquals(65.0, vehiculo.getKilometraje());
        assertEquals(0.0, vehiculo.getCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {

        assertThrows(
                RuntimeException.class,
                () -> {
                    new Vehiculo(-10.0);
                },
                "La cantidad de combustible no puede ser menor a 0.");

    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {

        Vehiculo vehiculo = new Vehiculo(10.0);
        
        Double velocidadEcologica = vehiculo.getVelocidadMaxima();
        
        // Avanzar a estándar
        vehiculo.avanzarTipoConduccion();
        Double velocidadEstandar = vehiculo.getVelocidadMaxima();
        
        // Avanzar a deportiva
        vehiculo.avanzarTipoConduccion();
        Double velocidadDeportiva = vehiculo.getVelocidadMaxima();

        assertTrue(velocidadEcologica < velocidadEstandar);
        assertFalse(velocidadEstandar > velocidadDeportiva);
        assertNotEquals(velocidadEstandar, velocidadDeportiva);
    }
}
