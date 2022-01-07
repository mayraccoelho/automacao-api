#language:pt
@Login
Funcionalidade: Realizar Login
  Testes da API de Login

  @LoginSucesso
  Cenario: Realizar Login com sucesso
    Dado que tenha um payload valido da API de Login
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  @LoginInvalido
  Esquema do Cenario: Realizar Login com <cenario>
    Dado que tenha um payload da API de Login com as seguintes informacoes
      | email | <email> |
      | senha | <senha> |
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 400 no response

    Exemplos:
      | cenario          | email              | senha    |
      | usuario invalido | invalido@gmail.com | 123456   |
      | senha invalida   | aluno@email.com    | invalida |