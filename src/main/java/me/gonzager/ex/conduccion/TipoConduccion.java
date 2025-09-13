package me.gonzager.ex.conduccion;

public interface TipoConduccion {
    
    Double consumo();

    Double velocidadMaxima();

    TipoConduccion siguiente();

    TipoConduccion anterior();

}