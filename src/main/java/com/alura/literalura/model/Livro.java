package com.alura.literalura.model;

import com.alura.literalura.dto.DadosAutor;
import com.alura.literalura.dto.DadosLivro;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ElementCollection
    private List<String> idiomas;
    @ManyToOne
    private Autor autor;
    private Integer numeroDownloads;

    public Livro(){}

    public Livro(Long id, String titulo, List<String> idiomas, Autor autor, Integer numeroDownloads) {
        this.id = id;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.autor = autor;
        this.numeroDownloads = numeroDownloads;
    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idiomas = dadosLivro.idiomas();
        this.autor = new Autor(dadosLivro.autor().get(0));
        this.numeroDownloads = dadosLivro.numeroDownloads();
    }
}
