package CEPSearch.models;

import CEPSearch.Exceptions.ErrorNullCEPException;

public class CEP {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;


    public CEP(CEPViaCEP cepJson) {
        if (cepJson.cep() == null){
            throw new ErrorNullCEPException("CEP Não encontrado");
        }
        this.cep = cepJson.cep();
        this.rua = cepJson.logradouro();
        this.complemento = cepJson.complemento();
        this.bairro = cepJson.bairro();
        this.cidade = cepJson.localidade();
        this.estado = cepJson.uf();
        this.ibge = cepJson.ibge();
        this.gia = cepJson.gia();
        this.ddd = cepJson.ddd();
        this.siafi = cepJson.siafi();
    }

    @Override
    public String toString() {
        return "(" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                ')';
    }
}
