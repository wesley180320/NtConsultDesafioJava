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
<br>
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008
}
<img width="1968" height="1032" alt="image" src="https://github.com/user-attachments/assets/b1baa071-0f94-46c0-b408-4c0a996cb34e" />

API: Api para atualizar livro passando o ID, com validação se o ID existe.
<br>
Metodo: PUT
<br>
URL:localhost:8080/livro/atualizar/{idLivro}
<br>
Body:
<br>
{
  "titulo": "Clean ",
  "autor": "Robert",
  "anoPublicacao": 2010
}
<br>
<img width="1968" height="965" alt="image" src="https://github.com/user-attachments/assets/fd99cbf1-f0ec-46bf-a0ab-152a10b6d48e" />

API: Api para buscar livros, com validação se existe livros na base de dados.
<br>
Metodo: GET
<br>
URL: localhost:8080/livro/buscarlivros
<br>
<img width="1964" height="1071" alt="image" src="https://github.com/user-attachments/assets/202b7531-f72e-4530-8876-2f8a6e89a954" />

API: Api para deletar um livro com validação se o id do livro existe
<br>
Metodo: DELETE
<br>
URL:localhost:8080/livro/deletar/{idLivro}
<br>
<img width="1954" height="850" alt="image" src="https://github.com/user-attachments/assets/14863ded-38d1-46fd-901e-8a081b36749c" />

