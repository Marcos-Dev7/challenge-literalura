package com.alura.literalura.principal;

import com.alura.literalura.dto.DadosLivro;
import com.alura.literalura.dto.DadosResposta;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivroRepository;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            try {


                System.out.println("""
                        1 - Buscar livro pelo titulo
                        2 - Listar livros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos em um determinado ano
                        5 - Listar livros em um determinado idioma
                        
                        0 - Sair
                        
                        """);
                System.out.print("Digite sua opção: ");
                opcao = Integer.parseInt(leitura.nextLine());

                switch (opcao) {
                    case 1:
                        buscarPeloTitulo();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLivrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção Invalida - Escolha conforme o MENU!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Houve um erro: " + e.getMessage());
            }
        }
    }



    private void buscarPeloTitulo() {
        System.out.println("Digite o titulo que deseja: ");
        var nomeLivro = leitura.nextLine();

        String endereco = "https://gutendex.com/books/?search=" + nomeLivro.replace(" ", "%20");
        ConsumoApi consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados(endereco);
        ConverteDados converteDados = new ConverteDados();
        var dados = converteDados.converteDados(json, DadosResposta.class);

        if (dados.resultado() != null && !dados.resultado().isEmpty()) {
            DadosLivro dadosLivro = dados.resultado().get(0);
            Livro livro = new Livro(dadosLivro);
            livroRepository.save(livro);

            System.out.println("Livro salvo com sucesso: " + livro.getTitulo());
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private void listarLivrosRegistrados() {
        var resultado = livroRepository.findAll();
        resultado.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> resultado = autorRepository.findAll();
        resultado.forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Digite o ano que deseja pesquisar");
        Integer anoDesejado = Integer.valueOf(leitura.nextLine());

        List<Autor> autoresVivos = autorRepository.buscarPeloAnoDesejado(anoDesejado);
        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor encontrado");
        } else {
            autoresVivos.forEach(System.out::println);
        }

    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Exemplo:
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                """);

        System.out.println("Digite a sigla desejada: ");
        var siglaDesejada = leitura.nextLine();
        try {
            var resultado = livroRepository.findByIdiomas(siglaDesejada);
            resultado.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Nenhum livro com a sigla encontrada!");
        }
    }
}
