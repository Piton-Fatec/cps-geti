## Requisitos Funcionais

| cod | Nome | Descrição |
|-----|------|-----------|
|RF01|Efetuar login|Autenticação dos usuários do sistema (membros do CPS, CRA, candidatos) para que os mesmos possam realizar as operações de acordo com a sua permissão|
|RF02|Gerenciamento de editais|**Adicionar edital**: Cadastro dos editais do processo seletivo para o curso de Pós-Graduação do CPS, considerando as singularidades de cada edital, como: definição do curso, público alvo, período de inscrição, quantitativo de vagas - ampla, ações afirmativas, candidatos com deficiência -, documentos exigidos; **Editar edital**: Em caso de erro no preenchimento das informações, o sistema deve permitir que o membro do CPS edite as informações do edital; **Remover edital**: Caso o edital seja cancelado ou ocorra qualquer outro evento em que o GETI necessite excluir o edital, o sistema deve possibilitar essa exclusão; **Consultar edital**: Os membros poderão consultar, de acordo com a sua permissão, os dados básicos dos editais|
|RF05|Inscrição para o edital|Inserção de dados do candidato para possibilitar a sua inscrição para o processo seletivo escolhido. Deve considerar, além do cadastro de dados básicos como nome e endereço, o *upload* de arquivos|
|RF06|Controle de *status* da inscrição|O fluxo para deferimento das inscrições até a classificação do candidato segue as etapas de validação dos documentos, análise curricular, entrevistas e atribuição da nota final. Todas com possibilidade de abertura de recurso pelo candidato. Dessa forma, o sistema deve possibilitar que o membro do CPS/CRA acompanhe a evolução do candidato durante o processo seletivo|
|RF07|Abertura de recurso|O candidato poderá entrar com recurso caso a sua candidatura seja indeferida em algum momento do processo (validação dos documentos, entrevistas, análise curricular)|
|RF08|Envio de e-mail para acompanhamento|O candidato poderá acompanhar a sua evolução no processo seletivo com notificações via e-mail|


## Requisitos não funcionais

| cod | Nome | Descrição |
| --- | ---- | --------- |
|RNF01|Ferramentas para desenvolvimento|O sistema deve ser elaborado utilizando apenas linguagem Java e os seus recursos|
|RNF02|Restrição de funcionalidades aos membros do CPS|O presidente do CPS e o coordenador do GETI terão acesso a todas as funcionalidades do sistema. Membros do CRA poderão apenas validar os documentos do candidato (CPF, RG, diploma). Membros do CPS terão acesso, além dos dados dos candidatos, ao currículo do mesmo|
|RNF03|Restrição de acesso aos candidatos|Os candidatos não terão acesso ao *status* de sua candidatura após um membro do CPS validar os seus documentos|
|RNF04|Restrição de inscrição fora do prazo|Após o período de inscrições do edital, não será permitido novas candidaturas, assim como o candidato que não entregou os documentos solicitados não poderá realizar esse procedimento após o prazo|
|RNF05|Método de desenvolvimento|O sistema deve ser elaborado utilizando técnicas de OO (Orientação a objeto)|
|RNF06|Usabilidade|O Sistema deve ser disponibilizado apenas para plataforma Desktop|
|RNF07|Armazenamento dos editais|Todos os editais devem ser armazenados para que o presidente e o coordenador do GETI possam consuntá-los|
