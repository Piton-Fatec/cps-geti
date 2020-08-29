## Requisitos Funcionais

| cod | Nome | Descrição |
|-----|------|-----------|
|RF01|Efetuar login|Autenticação dos usuários do sistema (membros do CPS, CRA) para que os mesmos possam realizar as operações de acordo com a sua permissão|
|RF02|Cadastrar edital|Cadastro dos editais do processo seletivo para o curso de Pós-Graduação do CPS, considerando as singularidades de cada edital, como: definição do curso, público alvo, período de inscrição, quantitativo de vagas - ampla, ações afirmativas, candidatos com deficiência -, documentos exigidos|
|RF03|Edição do edital|Em caso de erro no preenchimento das informações, o sistema deve permitir que o membro do CPS edite as informações do edital|
|RF04|Remoção do edital|Caso o edital seja cancelado ou ocorra qualquer outro evento em que o GETI necessite excluir o edital, o sistema deve possibilitar essa exclusão|
|RF05|Inscrição para o edital|Inserção de dados do candidato para possibilitar a sua inscrição para o processo seletivo escolhido. Deve considerar, além do cadastro de dados básicos como nome e endereço, o *upload* de arquivos|
|RF06|Controle de *status* da inscrição|O fluxo para deferimento das inscrições até a classificação do candidato segue as etapas de validação dos documentos, análise curricular, entrevistas e atribuição da nota final. Todas com possibilidade de abertura de recurso pelo candidato. Dessa forma, o sistema deve possibilitar que o membro do CPS/CRA acompanhe a evolução do candidato durante o processo seletivo|
|RF07|Abertura de recurso|O candidato poderá entrar com recurso caso a sua candidatura seja indeferida em algum momento do processo (validação dos documentos, entrevistas, análise curricular)|
|RF08|Envio de e-mail para acompanhamento|O candidato poderá acompanhar a sua evolução no processo seletivo com notificações via e-mail|


## Requisitos não funcionais

| cod | Nome | Descrição |
| --- | ---- | --------- |
|RNF01|Linguagem de programação|O sistema deve ser elaborado utilizando apenas linguagem de programação Java|
|RNF02|Método de desenvolvimento|O sistema deve ser elaborado utilizando técnicas de OO (Orientação a objeto)|
|RNF03|Usabilidade|O Sistema deve ser disponibilizado apenas para plataforma Desktop|
|RNF04|Restrição|O acesso integral as funcionalidades di sistema devem ser dispostas apenas ao presidente da CPS e ao coordenador do GETI|
|RNF05|Restrição|Os membros do CRA podem apenas validar documentações (CPF, RG, diploma etc)|
|RNF06|Restrição|Os membros da CPS podem apenas avaliar o currículo do candidato|
|RNF07|Armazenamento dos editais|Todos os editais devem ser armazenados para que o presidente e o coordenador do GETI possam consuntá-los|
