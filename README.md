# testedevoperacional

Após analisar por algum tempo o sistema, identifiquei algumas possíveis melhorias. 
##
  - Extrai diversas partes do código em métodos menores. Desta maneira, fica mais fácil de manter e modificar o código, além de facilitar a leitura e compreensão em geral.

  - Adicionei a prática de polimorfismo ao fazer as classes Cliente, Empresa extenderem a classe Usuário, além de criar a classe Admin (que também extende Usuário). Após fazer isso, alguns ajustes tiveram de ser feitos no código.
  
  - Mudei o ID para o tipo Long.
  
  - Método toString na classe Empresa e Produto.
  
  - Ambas as classes Cliente e Empresa têm ID. Desta maneira, há um jeito de identificar cada empresa ou cliente separadamente, não apenas como usuário.
    
  - Após a realização de uma compra, o saldo da empresa responsável pela venda não era ajustada adequadamente de acordo com as taxas que pagava. Isso geraria um engano nos extratos financeiros, pois o total líquido viria sem os descontos das taxas.
  
  - Coleções de Produtos, Clientes e Empresas foram trocadas para a interface Set, com a implementação HashSet. Foi feito já que não devem existir duplicatas no sistema, além de permitir uma manipulação mais rápida dos dados. Porém, as coleções de produtos e vendas permaneceram como List, já que a ordenação, de certa maneira, importa. 
