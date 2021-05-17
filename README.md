# Gerenciador de tarefas
## O projeto 
O presente projeto é um simples sistema de gerenciamento de tarefas, parte do processo seletivo de ingresso no Grupo **ESIG**. O sistema consiste em uma simples _single page application_ que é capaz de executar as seguintes funcionalidades: 
- Criar uma tarefa
- Listar tarefas criadas
- Atualizar (editar) tarefas
- Excluir tarefas
>Possuindo esta tarefa as seguintes características:
>  - Título
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
## Instruções para rodar o projeto localmente
Para iniciar o projeto em uma máquina local, é preciso primeiramente ter instalado o **Java 8**, uma IDE de sua escolha, o Maven e o sistema gerenciador de banco de dados objeto relacional PostgreSQL
> Caso a IDE escolhida seja o Eclipse, o Maven já vem embutido, não sendo necessário instalá-lo.
> - Instalação e configuração do java: https://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188
> - Instalação e configuração do PostgreSQL: https://www.devmedia.com.br/instalando-postgresql/23364
> - Maven: http://maven.apache.org

Após isso, é necessário instalar também um container web para rodar o projeto localmente, no caso do projeto está sendo utilizado o Apache Tomcat na versão **8.5**. Verificar também a porta em que o servidor estará rodando. 
> - Instalação e configuração do Tomcat na IDE Eclipse: https://www.devmedia.com.br/instalacao-e-configuracao-do-apache-tomcat-no-eclipse/27360

Após isso, basta acessar o PgAdmin, ferramenta de gerenciamento de bancos do PostgreSQL (ou outro gerenciador de sua preferência), criar uma base de dados chamada **"taskmanager"**, e dentro desta base de dados, no _schema_ public, criar uma tabela chamada **"task"**.

Feito isso, basta clonar o projeto e adicionar ele à IDE como um _Existing Maven Project_ e adicioná-lo ao servidor Tomcat configurado anteriormente.

O último passo consiste em acessar o arquivo _hibernate.cfg.xml_ e alterar as propriedades de url de conexão, nome de usuário e senha, preenchendo estas com os dados de acesso ao banco que você anteriormente criou. 
Com esses passos concluídos, basta inicializar o servidor e abrir no seu navegador o seguinte endereço:
> localhost:{porta_configurada_no_tomcat}/Taskmanager/pages/index.xhtml

> Exemplo: localhost:8085/Taskmanager/pages/index.xhtml

A página irá mostrar a interface do gerenciador de tarefas, pronta para uso.
> Obs: dentro do arquivo _hibernate.cfg.xml_ a propriedade _hibernate.hbm2ddl.auto_ está no modo _create_, o que significa que uma nova tabela vazia será gerada sempre que o servidor for reinicializado. Para manter os dados após iniciá-lo pela primeira vez, basta alterar essa propriedade para o modo _update_.
