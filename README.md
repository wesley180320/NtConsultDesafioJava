JDK: 17
Tecnologias utilizadas: Spring Boot, Java, H2, Junit, JPA.  

Decisões técnicas:
<br>
Spring Boot: Para utilizar as anotações e facilicar o desenvolvimento das APIS REST
<br>
H2: Banco de dados em memoria utilizado em desenvolvimento.
<br>
Junit: Para realizar testes nas APIS.
<br>
Jpa: Para realizar consultas no banco e salvar dados.

APIS:

API: Api para salvar os dados do livro, com validação de body e evitar salvar dois livros iguais.
<br>
Metodo: POST
<br>
URL: localhost:8080/livro/
<br>
Body:
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008
}
<img width="1975" height="738" alt="image" src="https://github.com/user-attachments/assets/2b4b3543-a9ea-40ed-a4fb-f01e7696318d" />

API: Api para atualizar livro passando o ID, com validação se o ID existe.
<br>
Metodo: PUT
<br>
URL:localhost:8080/livro/atualizar/{idLivro}
<br>
Body:
{
  "titulo": "Clean ",
  "autor": "Robert",
  "anoPublicacao": 2010
}
<br>
<img width="1967" height="778" alt="image" src="https://github.com/user-attachments/assets/e6056588-3d06-4066-aee6-2cf3246f7f42" />

API: Api para buscar livros, com validação se existe livros na base de dados.
<br>
Metodo: GET
<br>
URL: localhost:8080/livro/buscarlivros
<br>
<img width="1963" height="819" alt="image" src="https://github.com/user-attachments/assets/dccaaa1e-fa96-4700-8983-406e88659880" />

API: Api para deletar um livro com validação se o id do livro existe
<br>
Metodo: DELETE
<br>
URL:localhost:8080/livro/deletar/{idLivro}
<br>
<img width="1954" height="850" alt="image" src="https://github.com/user-attachments/assets/14863ded-38d1-46fd-901e-8a081b36749c" />

