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
<img width="1375" height="856" alt="image" src="https://github.com/user-attachments/assets/e741841d-a99f-476d-8f2e-780a749bf332" />

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
<img width="1963" height="963" alt="image" src="https://github.com/user-attachments/assets/be717534-a18b-4232-9361-ed06fecaaff5" />

API: Api para buscar livros, com validação se existe livros na base de dados.
<br>
Metodo: GET
<br>
URL: localhost:8080/livro/buscarlivros
<br>
<img width="1978" height="1076" alt="image" src="https://github.com/user-attachments/assets/39253120-1ac3-421e-b07e-abd4db52f64c" />

API: Api para deletar um livro com validação se o id do livro existe
<br>
Metodo: DELETE
<br>
URL:localhost:8080/livro/deletar/{idLivro}
<br>
<img width="1974" height="875" alt="image" src="https://github.com/user-attachments/assets/15c6ef15-8173-49b1-a411-3cbc3ed87e21" />

