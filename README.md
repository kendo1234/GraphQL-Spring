Tutorial project for GraphQL.

Taken from - https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/

Queried API using GraphQLPlayground desktop app - https://github.com/prisma-labs/graphql-playground/releases

Application creates endpoint -  http://localhost:8080/graphql

Example Query:

```

{
collectionById(id: "collection-1") {
    id
    name
    collectionDate
    Owner {
      firstName
      lastName
    }
  }
}


```

Example Response:

```

{
  "data": {
    "collectionById": {
      "id": "collection-1",
      "name": "Banana",
      "collectionDate": 441806400,
      "Owner": {
        "firstName": "Joe",
        "lastName": "Bloggs"
      }
    }
  }
}

```