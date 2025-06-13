package br.com.climaconsciente.models;

import br.com.climaconsciente.enums.NivelRisco;

public class Temperatura {

    //-------- Atributo --------
    private double graus;

    // -------- Construtores --------
    public Temperatura() {
    }

    public Temperatura(double graus) {
        this.graus = graus;
    }

    public double getGraus() {
        return graus;
    }

    public void setGraus(double graus) {
        this.graus = graus;
    }

    // -------- Metodos --------

    public NivelRisco avaliarRisco(){
        if (graus < 30){
            return NivelRisco.BAIXO;
        } else if(graus <= 38){
            return NivelRisco.ALTO;
        } else{
            return  NivelRisco.CRITICO;
        }
    }

    // -------- Sobrecarga --------
    public String exibirTemperatura(){
        return graus + "ºC";
    }

    public String exibirTemperatura(boolean formatado){
        return formatado ? graus + " graus Celcius" : graus + "ºC";
    }



}
