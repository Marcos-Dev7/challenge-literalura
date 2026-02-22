package com.alura.literalura;

import com.alura.literalura.dto.DadosResposta;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi novoConsumo = new ConsumoApi();

		var json = novoConsumo.obterDados("https://gutendex.com/books/?search=Dom%20Casmurro");
		ConverteDados conversor = new ConverteDados();
		var dados = conversor.converteDados(json, DadosResposta.class);

		System.out.println(dados.resultado());
	}
}
