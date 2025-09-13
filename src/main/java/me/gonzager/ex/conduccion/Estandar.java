package me.gonzager.ex.conduccion;

public class Estandar implements TipoConduccion {

    @Override
    public Double consumo(){
        return 10.0;
    };

    @Override
    public Double velocidadMaxima(){
        return 150.0;
    };

    @Override
    public TipoConduccion anterior(){
        return new Ecologica();
    };

    @Override
    public TipoConduccion siguiente(){
        return new Deportiva();
    };

}
