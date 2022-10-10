# testedevoperacional

Após analisar por algum tempo o sistema, identifiquei algumas possíveis melhorias.

##

1 - Adicionei a prática de polimorfismo ao fazer as classes Cliente, Empresa extenderem a classe Usuário, além de criar a classe Admin (que também extende Usuário). Após fazer isso, alguns ajustes tiveram de ser feitos no código.
2 - Mudei o ID para o tipo Long.
3 - Ambas as classes Cliente e Empresa têm ID. Desta maneira, há um jeito de identificar cada empresa ou cliente individualmente, não apenas como usuário.
4 - Após a realização de uma compra, o saldo da empresa responsável pela venda não era ajustada adequadamente de acordo com as taxas que pagava. Isso geraria um engano nos extratos financeiros, pois o total líquido viria sem os descontos.
5 - Coleções de Produtos, Clientes e Empresas foram trocadas para a interface Set, com a implementação HashSet. Foi feito já que não devem existir duplicatas no sistema, além de permitir uma manipulação mais rápida dos dados. Porém, as coleções de produtos permaneceram como List, já que a ordenação, de certa maneira, importa. 
