package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("id") Long id,
                         @JsonAlias("title") String titulo,
                         @JsonAlias("languages") List<String> idiomas,
                         @JsonAlias("authors")List<DadosAutor> autor,
                         @JsonAlias("download_count") Integer numeroDownloads) {
}
