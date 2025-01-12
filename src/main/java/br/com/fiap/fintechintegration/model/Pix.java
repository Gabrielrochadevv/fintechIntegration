package br.com.fiap.fintechintegration.model;

public class Pix {

    private String chavePix;
    private double valorPix;
    private String descricaoPix;

    public Pix() {

    }

    public Pix(String chavePix, double valorPix, String descricaoPix) {
        this.chavePix = chavePix;
        this.valorPix = valorPix;
        this.descricaoPix = descricaoPix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public double getValorPix() {
        return valorPix;
    }

    public void setValorPix(double valorPix) {
        this.valorPix = valorPix;
    }

    public String getDescricaoPix() {
        return descricaoPix;
    }

    public void setDescricaoPix(String descricaoPix) {
        this.descricaoPix = descricaoPix;
    }
}
