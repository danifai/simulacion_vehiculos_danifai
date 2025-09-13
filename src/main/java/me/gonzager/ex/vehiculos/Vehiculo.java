package me.gonzager.ex.vehiculos;

import me.gonzager.ex.conduccion.*;

public class Vehiculo {
    private Double cantidadDeCombustible;
    private Double kilometraje;
    private TipoConduccion tipoConduccion;

    public Vehiculo(Double combustibleInicial){
        if (combustibleInicial < 0) {
            throw new RuntimeException("La cantidad de combustible no puede ser menor a 0.");
        }
        this.cantidadDeCombustible = combustibleInicial;
        this.kilometraje = 0.0;
        this.tipoConduccion = new Ecologica();
    }

    public Double getCombustible() {
        return cantidadDeCombustible;
    }
    
    public Double getKilometraje() {
        return kilometraje;
    }
    
    public Double getConsumo() {
        return tipoConduccion.consumo();
    }
    
    public Double getVelocidadMaxima() {
        return tipoConduccion.velocidadMaxima();
    }
    
    public TipoConduccion getTipoConduccion() {
        return tipoConduccion;
    }

    public void avanzarTipoConduccion() {
        this.tipoConduccion = tipoConduccion.siguiente();
    }

    public void retrocederTipoConduccion() {
        this.tipoConduccion = tipoConduccion.anterior();
    }

    public void desplazar(Double kilometrosARecorrer) {
        Double consumoActual = tipoConduccion.consumo();
        Double combustibleNecesario = kilometrosARecorrer / consumoActual;
        
        if (cantidadDeCombustible >= combustibleNecesario) {
            cantidadDeCombustible -= combustibleNecesario;
            kilometraje += kilometrosARecorrer;
        } else {
            Double kilometrosRecorridos = cantidadDeCombustible * consumoActual;
            kilometraje += kilometrosRecorridos;
            cantidadDeCombustible = 0.0;
            
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + kilometrosRecorridos
                    + " del total de " + kilometrosARecorrer + " kilometros.");
        }
    }

}

