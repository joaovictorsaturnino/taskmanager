# Gerenciador de tarefas
## O projeto 
O presente projeto é um simples sistema de gerenciamento de tarefas, parte do processo seletivo de ingresso no Grupo **ESIG**. O sistema consiste em uma simples _single page application_ que é capaz de executar as seguintes funcionalidades: 
- Criar de uma tarefa
- Listar das tarefas criadas
- Atualizar (editar) tarefas
- Excluir tarefas
>Possuindo esta tarefa as seguintes características:
> - Título
>  - Descrição
>  - Número
>  - Responsável 
>  - Prioridade (baixa, média e alta)
>  - Deadline (data limite para o cumprimento da mesma)
>  - Situação (em andamento ou concluída)
## Desenvolvimento
###  De acordo com os itens previstos no documento que especifica a atividade

O sistema de gerenciamento de tarefas é uma aplicação Java Web que utiliza a especificação Java para a construção de interfaces de usuário JavaServer Faces (JSF) (**item a**), utiliza a persistência de dados através de um banco de dados PostgreSQL (**item b**) e que também utiliza da API Java Persistence API (JPA) para realizar essa persistência(**item c**), através do framework Hibernate. 
> O projeto foi construído utilizando o padrão de arquiterura de software MVC(Model, View, Controller)
#### Diferenciais
Como diferenciais presentes no projeto, destaco o fato da aplicação ter sido utilizando a ferramenta de gerenciamento e automação de projetos Maven, otimizando e padronizando a importação de bibliotecas necessárias para o funcionamento do sistema(que podem ser encontradas no arquivo pom.xml, presente na raiz do projeto) e o próprio Hibernate como implementação da JPA. Também utilizo testes de unidades, (**item d**) através do JUnit, em alguns métodos presentes no projeto.  Para melhoria do design da interface, utilizo a biblioteca de componentes PrimeFaces no front-end.
> Observações gerais:
> - Por se tratar de um projeto simples, não foram adicionadas regras de negócio que visem proibir situações impossíveis ou pouco prováveis, como criar uma tarefa com deadline para o dia de ontem, ou criar uma tarefa com o campo 'nome' em branco.
> - No que se refere aos campos "responsável" e "prioridade" optei por inseri-los estaticamente, sendo um possível diferencial criar um cadastro de responsáveis e de prioridades, diferencial esse que acabou não sendo cumprido em função da deadline para a entrega do projeto.
