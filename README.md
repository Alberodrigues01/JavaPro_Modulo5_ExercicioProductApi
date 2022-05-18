# JavaPro_Modulo5_ExercicioProductApi
Exercício simula uma API para movimentação de estoque (addProduct e reduceRoduct) e para a execução de uma Ordem de Venda (Order),
com o objetivo de realizar testes de validação: unitários e de ingração.
Os testes utilizam os aplicativos JUNIT e Mockito(para testes de integração).
Os produtos (TV, Geladeira, Fogão e Lavadora) já estão criados (instanciados) na List<Product>products.
A Ordem de Venda (Order) deve ser executada pelo serviço POST no Postman informando os atributos de Product mais as informações
de quantity e discount. Deve ser informado no formato JSON.
Os testes unitários são realizados sobre: a quantidade máxima em estoque que pode ser vendida, o valor máximo de desconto que
que pode ser aplicado e o calculo final (somatório) do preço final da Ordem.
Os testes de integração envolvem o funcionamento da camada Controller com o serviço Http.
Não utilizamos neste exercício a funcionalidade de Banco de Dados.  
  
