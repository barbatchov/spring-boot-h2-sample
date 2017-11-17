Crud simples Spring-boot e H2!
=
Este é só um crud simples para funcionar com Springboot e H2.
Foi criado um teste de integração para assertar o conteúdo da RestController.

O banco fica em **src/main/resources/db/database.h2.mv.db**
A configuração da aplicação utiliza esse arquivo como banco.
Para o teste, usamos o mesmo só que em memória.
O Hibernate criará o conteúdo quando a aplicação subir.

Para abrir pelo intellij entre em **New > Project from existing source > Maven**;

As urls da api são:
```
PUT /os [json body]
GET /os?id=#
DELETE /os?id=#
```
