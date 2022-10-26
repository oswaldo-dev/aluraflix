package br.com.alura.aluraflix.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
public class RequestVideoDto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @URL
    @NotBlank
    private String url;
}
