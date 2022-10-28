package br.com.alura.aluraflix.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemErro {

    private List<String> validationList;
    public MensagemErro(List<String> validationList) {
        this.validationList = validationList;
    }
}
