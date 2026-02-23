package com.alura.literalura.model;

import com.alura.literalura.dto.DadosLivro;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> idiomas;
    @ManyToOne(cascade = CascadeType.ALL)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return """
                ------------------------ LIVRO %s -----------------------------
                 Título:  %s
                "Autor: "  %s
                "Idioma: " %s
                "Downloads: " %d
                "--------------------------------------------------------------""".formatted(id,titulo, autor.getNome(), idiomas, numeroDownloads);
    }
}
