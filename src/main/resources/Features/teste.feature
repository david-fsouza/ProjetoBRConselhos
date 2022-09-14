# language: pt
# encoding: Cp1252

Funcionalidade: BRConselhos - Modulo Financeiro
  
  Executa as seguintes operações:
  
  - Consulta de registro na funcao Contas a Receber
  - Consulta de registro na função Integração Bancária

  Contexto: 
    Dado que esteja na tela de login
    Quando informar o usuario "brconselhos" e senha "a123"
    Entao o sistema exibe tela inicial
    E acessa o modulo Financeiro

  Cenario: Consulta registro Contas a Receber
    Dado que acesse a funcao Contas a Receber
    E pesquise por "003505" e selecione o registro
    Entao o sistema exbibe a mensagem "Data de execução"
    
  Cenario: Consulta registro Integração Bancária
    Dado que acesse a função Integracao Bancaria
    E pesquise por "CBR6436313108201800001.ret" no campo filtrar
    Entao o sistema valida a mensgem "Integração Bancária de Retorno ou Remessa"
    
