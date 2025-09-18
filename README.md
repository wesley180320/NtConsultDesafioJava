JDK: 17
Tecnologias utilizadas: Spring Boot, Java, H2, Junit, JPA.  

APIS:

API: Api para salvar os dados do livro, com validação de body e evita salvar dois livros iguais.
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
<img width="1394" height="729" alt="image" src="https://github.com/user-attachments/assets/e43bdb0e-0cb4-459c-8f84-2762f8f3eb0a" />

API: Api para buscar livros, com validação se existe livros na base de dados.
<br>
Metodo: GET
<br>
URL: localhost:8080/livro/buscarlivros
<br>
<img width="1565" height="1198" alt="image" src="https://github.com/user-attachments/assets/8a50481b-c767-45a8-9766-418691deb9a4" />

API: Api para deletar um livro com validação se o id do livro existe
<br>
Metodo: DELETE
<br>
URL:localhost:8080/livro/deletar/{idLivro}
<br>
<img width="1689" height="664" alt="image" src="https://github.com/user-attachments/assets/23ee6961-4621-491d-b511-18faa7efa48a" />
