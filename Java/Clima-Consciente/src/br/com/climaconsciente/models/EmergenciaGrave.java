package br.com.climaconsciente.models;

import br.com.climaconsciente.enums.NivelRisco;

public class EmergenciaGrave extends AlertaClimatico {
    private NivelRisco nivelRisco;

    public EmergenciaGrave(String mensagem, NivelRisco nivelRisco) {
        super(mensagem); // chama o construtor da superclasse
        this.nivelRisco = nivelRisco;
    }

    public NivelRisco getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(NivelRisco nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    // Metodo sobrescrito (sobrescrita = override)
    @Override
    public String getMensagem() {
        return "[ALERTA] (Risco: " + nivelRisco + ") CUIDE-SE!!!!";
    }
}

