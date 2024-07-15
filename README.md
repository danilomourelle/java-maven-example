Esse repositório é uma continuação do projeto java-complete-course

## Sessão 22: Java EE - ORM com JPA

A ideia dessa seção é mostrar uma estrutura de ORM. Na sessão anterior a gente tinha que ficar tratando os dados de uma entidade toda vez que fazia alguma manipulação no banco de dados. Sem contar que tínhamos que fazer as interações em código SQL mesmo. Isso lembra mais ou menos a situação que tinha como o knex (query builder) nas aulas do Goli.

Assim como o Prisma, Sequelize, ou TypeORM, o Java permite a utilização de ORM que vão fazer esse abstração do banco de dados para objeto. Pelo que entendi, o termo JPA se refere a uma convenção de como essa abstração deve ser feita, já quem faz mesmo é uma biblioteca chamada Hibernate (a mais utilizada). 

Para utilizar uma biblioteca, é necessário ter um gerenciado de pacote, como é o **npm**. Para o Java, esse gerenciador é o Maven, então por isso foi criado um projeto novo, indicando ser um projeto como dependências Maven, para que toda a estrutura necessária já fosse montada. Esses projetos vão apresentar um arquivo chamado `pom.xml` que é o manifesto das dependências, mais ou menos como é o package-lock. A diferença é que ao invés de rodar um comando CLI para instalar a dependência, você encontra ela no repositório Maven e copia o código xml para o seu pom.xml, e assim que salvar, ele já será baixado. 

Quando baixado, eles não ficam alocados no local do projeto como a node_modules, mas sim ficam em um lugar comum, independente do projeto, dessa forma, caso mais de um projeto utilize o mesmo pacote, não há a necessidade de se baixar ele mais de uma vez. No linux, o caminho para esses pacotes é `~/.m2/repository`.

Depois de configurado o projeto, e as dependências, a gente também precisa configurar um arquivo `persistence.xml` que vai conter as configurações de como o Hibernate vai se conectar com o banco. É como se fosse o prisma.schema, porém menos focado na parte de modelagem e mais focado na parte de driver e conexão.

Todas as configurações sendo feitas, basta fazer as indicações de qual entidade deve ser relacionada com uma tabela, e como os seus campos vão ser relacionados a essa coluna da tabela. Isso é feito na própria classe da entidade e vai ser feita através de decorators, lembra um pouco a estrutura de NestJS ou do TypeORM. 

Uma vez assinaladas as relações, para a real interação com o banco, basta criar uma *EntityManagerFactory* passando o arquivo de “persistence” como parâmetro, e com essa factory você cria uma instância de *EntityManager*. Essa instância vai dar acessos a métodos que vão fazer essa abstração. É bom ressaltar que para métodos que realizam alterações de dados, como o `persist` e o `remove`, estes comando dever estar englobados por uma transação como o `getTransaction().begin()` e `getTransaction().commit()`.