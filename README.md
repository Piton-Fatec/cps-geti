# Projeto integrado CPS-GETI

> Projeto integrado das disciplinas Engenharia de Software II e Estruturas de Dados



## Definição do Sistema

Os atos administrativos são divulgados oficialmente para amplo conhecimento por meio de um edital. O processo seletivo para o curso de Pós-Graduação (GETI) é divulgado semestralmente por um edital, cuja elaboração é responsabilidade da Comissão do Processo Seletivo (CPS) para o GETI.

Este edital é composto por definições do curso, do público alvo, período de inscrição, quantitativo de vagas por tipo: ampla concorrência, ações afirmativas e candidatos com deficiência. Este quantitativo não é fixo e pode ser alterado a cada edital. Os documentos exigidos podem ser alterados para cada câmpus, pois fica a cargo deles construírem o edital.Cada edital especifica um cronograma de atividades composta com datas definidas previamente.

Segue um exemplo do processo seletivo para o primeiro semestre de 2020, conforme o Quadro 1.



![table](https://github.com/Piton-Fatec/cps-geti/blob/master/imgs/table.png)



O processo seletivo conta com duas etapas: análise do currículo e entrevista. A análise de currículo é realizada após a homologação das inscrições. A análise da inscrição é realizada pela CPS ou mesmo pela Coordenação de Registro Acadêmico (CRA) verificando se os documentos entregues são válidos. Não são exigidos documentos originais ou cópias autenticadas, apenas cópias simples.

Após a constatação que os documentos são válidos, é publicada a divulgação prévia do deferimento das inscrições. Caso um candidato tenha sua inscrição indeferida, ele pode solicitar um recurso para reavaliação do seu processo. A etapa de análise de currículo e entrevista também permitem a solicitação de recursos.



## Histórico das Inscrições
Inicialmente, os candidatos se inscreviam na secretaria, entregando a documentação física exigida pelo edital. Em processo continuo de melhoria, as inscrições do segundo semestre de 2019 tornaram- se digitais, com entrega de documentos via e-mail para a CRA. Porém, o processo interno não teve a mesma evolução que desejamos.

## Futuro das Inscrições
A CPS necessita de um sistema que possa automatizar todo o processo, com a inscrição, publicação, análise dos documentos e currículo digital, melhorando o processo totalmente. Foram elaborados os requisitos funcionais iniciais para a construção do sistema. Um desejo futuro é a publicação por meio de envio de e-mail, em que as pessoas possam se cadastrar para terem notícias sobre do processo seletivo


## Regras de Negócio
**RN01**: Os candidatos devem entregar os documentos para que a inscrição possa ser validada.

**RN02**: O sistema deve atender o período do edital, não aceitando inscrições fora do prazo e não aceitando entrega de documentos depois do encerramento das inscrições.

**RN03**: Quando um membro da CPS validar os documentos, o sistema não deve mostrar para o candidato o seu status.

**RN04**: Será necessário manter dois tipos de usuário: presidente da CPS, o coordenador do GETI e os outros usuários. O coordenador e o presidente da CPS podem executar todas as funções do sistema; os membros da CRA podem apenas validar os documentos como CPF, RG, diploma e etc. Apenas membros da CPS pode avaliar o currículo do candidato.

**RN05**: o sistema deve armazenar todos os editais passados, sendo que os membros da CRA e da CPS podem ver apenas o edital presente.



## Como contribuir

Faça o fork deste projeto para o seu repositório:

https://github.com/SEUUSUARIO/cps-geti/fork

Ou clique no botão `fork` no canto superior direito da página do projeto:

![fork-button](https://github.com/Piton-Fatec/cps-geti/blob/master/imgs/fork-button.png)


Abra o seu terminal, escolha um local e clone o projeto localmente por meio do link HTTPS ou SSH do seu repositório forkado:

![clone](https://github.com/Piton-Fatec/cps-geti/blob/master/imgs/clone.png)

```bash
git clone https://github.com/SEUUSUARIO/cps-geti.git
```

Na pasta do repositório clonado, crie uma nova `branch` com o seguinte comando:

```bash
git checkout -b nome-da-branch

git checkout -b devel
```

Faça as alterações que deseja e faça o `commit` com os seguintes passos:

```bash
git add *
git commit -am 'descrição breve das alterações realizadas'
git push origin devel
```

O comando `add *` do git adiciona todas as modificações feitas no repositório para o INDEX (área temporária). O `commit` confirma essas modificações e, então, são inseridas no HEAD o qual aponta o último commit realizado no repositório. Finalmente, o comando `push` envia as alterações para o repositório remoto (github) especificamente para o `branch` especificado (devel).

Após realizar esses passos, acesse a página github do repositório forkado. Nessa paǵina, terá uma mensagem solicitando a revisão da alteração enviada para realizar o *pull request* para a branch `master` do repositório forkado:

![compare-pull-requests](https://github.com/Piton-Fatec/cps-geti/blob/master/imgs/compare-pull-request.png)

Revise a alteração e insira comentários caso necessário e finalmente crie o *pull request*:

![create-pull-request](https://github.com/Piton-Fatec/cps-geti/blob/master/imgs/create-pull-request.png)


## TODO

- [ ] Elicitar os requisitos
- [ ] Casos de uso
- [ ] Protótipos

* Marcar horários com a professora para validar os requisitos

