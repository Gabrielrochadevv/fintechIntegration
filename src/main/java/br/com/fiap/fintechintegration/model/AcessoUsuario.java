package br.com.fiap.fintechintegration.model;

import br.com.fiap.fintechintegration.util.CriptografiaUtils;

public class AcessoUsuario {

    private String dsemail;
    private String dssenha;

    public AcessoUsuario(String dsemail, String dssenha) {
        super();
        this.dsemail = dsemail;
        setDssenha(dssenha);
    }

    public AcessoUsuario() {
        super();
    }

    public String getDsemail() {
        return dsemail;
    }

    public void setDsemail(String dsemail) {
        this.dsemail = dsemail;
    }

    public String getDssenha() {
        return dssenha;
    }

    public void setDssenha(String dssenha) {
//        try {
//            this.dssenha = CriptografiaUtils.criptografar(dssenha);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        this.dssenha = dssenha;
    }
}

