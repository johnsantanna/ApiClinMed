package clin.med.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import clin.med.api.dto.EnderecoDTO;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
    }

    public void updateDados(EnderecoDTO dados) {
        if (dados.logradouro() != null) { this.logradouro = dados.logradouro();}
        if (dados.numero() != null) { this.numero = dados.numero();}
        if (dados.bairro() != null) { this.bairro = dados.bairro();}
        if (dados.cep() != null) { this.cep = dados.cep();}
        if (dados.cidade() != null) { this.cidade = dados.cidade();}
        if (dados.uf() != null) { this.uf = dados.uf();}
        if (dados.complemento() != null) { this.complemento = dados.complemento();}
    }

    public void updateDados(Endereco dados) {
        if (dados.logradouro != null) { this.logradouro = dados.logradouro;}
        if (dados.numero != null) { this.numero = dados.numero;}
        if (dados.bairro != null) { this.bairro = dados.bairro;}
        if (dados.cep != null) { this.cep = dados.cep;}
        if (dados.cidade != null) { this.cidade = dados.cidade;}
        if (dados.uf != null) { this.uf = dados.uf;}
        if (dados.complemento != null) { this.complemento = dados.complemento;}
    }

}
