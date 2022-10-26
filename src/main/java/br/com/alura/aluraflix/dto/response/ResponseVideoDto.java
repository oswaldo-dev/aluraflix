package br.com.alura.aluraflix.dto.response;

import lombok.Data;

@Data
public class ResponseVideoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
}
