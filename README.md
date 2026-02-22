# LiterAlura - Catálogo de Livros 📚

Projeto desenvolvido para o desafio de Java e Spring Boot da Alura. O sistema realiza o consumo da API **Gutendex**, processa dados JSON e persiste as informações em um banco de dados **PostgreSQL**, permitindo buscas dinâmicas e filtros inteligentes através de uma interface de linha de comando (CLI).

## 🛠️ Tecnologias e Ferramentas

* **Java 25+**
* **Spring Boot 4.0.3**
* **Spring Data JPA**: Persistência de dados e consultas JPQL.
* **PostgreSQL**: Banco de dados relacional (Rodando em Home Server/TV Box).
* **Jackson**: Desserialização de dados da API.
* **API Gutendex**: Fonte de dados para os livros.

## ⚙️ Funcionalidades

O sistema oferece um menu interativo com as seguintes opções:

| Opção | Funcionalidade | Descrição |
| :--- | :--- | :--- |
| **1** | **Buscar livro pelo título** | Consulta a API, processa o JSON e salva o livro e autor no banco. |
| **2** | **Listar livros registrados** | Exibe todos os livros salvos no banco de dados local. |
| **3** | **Listar autores registrados** | Mostra os autores salvos e suas respectivas obras. |
| **4** | **Autores vivos em determinado ano** | Filtra autores no banco com base em um ano específico. |
| **5** | **Listar livros por idioma** | Filtra a coleção por siglas (`pt`, `en`, `fr`, `es`). |

## 🚀 Como Executar

### 1. Configuração do Banco de Dados
No arquivo `src/main/resources/application.properties`, configure sua conexão:
```properties
spring.datasource.url=jdbc:postgresql://SEU_IP:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
### 2. Execução
Clone o repositório e execute via terminal:

```Bash
git clone [https://github.com/Marcos-Dev7/LiterAlura.git](https://github.com/Marcos-Dev7/LiterAlura.git)
cd LiterAlura
mvn spring-boot:run
```

# 🧠 Desafios Técnicos Superados
* Tratamento de Lazy Loading: Uso estratégico de FetchType.EAGER para carregamento de coleções.

* Mapeamento Bidirecional: Relacionamentos @ManyToOne e @OneToMany entre as entidades Livro e Autor.

* Queries Personalizadas: Implementação de consultas JPQL customizadas no Repository.

* Infraestrutura: Configuração de banco de dados em ambiente Linux (Armbian/CasaOS).



## 👤 Autor

Desenvolvido por **Marcos Paulo de Freitas Pereira**

* **GitHub:** [Marcos-Dev7](https://github.com/Marcos-Dev7)
* **Localidade:** Contagem - MG