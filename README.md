Tutorial project for GraphQL.

Taken from - https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/

Queried API using GraphQLPlayground desktop app - https://github.com/prisma-labs/graphql-playground/releases

Example Query:

```

{
  bookById(id: "book-1"){
    id
    name
    pageCount
    author {
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
    "bookById": {
      "id": "book-1",
      "name": "Harry Potter and the Philosopher's Stone",
      "pageCount": 223,
      "author": {
        "firstName": "Joanne",
        "lastName": "Rowling"
      }
    }
  }
}

```