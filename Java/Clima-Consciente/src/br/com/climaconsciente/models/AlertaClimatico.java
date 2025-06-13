package br.com.climaconsciente.models;

import br.com.climaconsciente.enums.NivelRisco;

public class AlertaClimatico {
    private String mensagem;

    public AlertaClimatico(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

