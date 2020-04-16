package com.example.graphqlspring.bookdetails;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Data fetcher for every field in the schema
@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> collections = Arrays.asList(
            ImmutableMap.of("id", "collection-1",
                    "name", "Banana",
                    "collectionDate", "441806400",
                    "ownerId", "owner-1"),
            ImmutableMap.of("id", "collection-2",
                    "name", "Potato",
                    "collectionDate", "4418064001",
                    "ownerId", "owner-2"),
            ImmutableMap.of("id", "collection-3",
                    "name", "Avocado",
                    "collectionDate", "4418064002",
                    "ownerId", "owner-3")
    );

    private static List<Map<String, String>> owners = Arrays.asList(
            ImmutableMap.of("id", "owner-1",
                    "firstName", "Joe",
                    "lastName", "Bloggs"),
            ImmutableMap.of("id", "owner-2",
                    "firstName", "John",
                    "lastName", "Doe"),
            ImmutableMap.of("id", "owner-3",
                    "firstName", "Alan",
                    "lastName", "Smithee")
    );

    public DataFetcher getCollectionByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String collectionId = dataFetchingEnvironment.getArgument("id");
            return collections
                    .stream()
                    .filter(collection -> collection.get("id").equals(collectionId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getOwnerDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> collection = dataFetchingEnvironment.getSource();
            String ownerId = collection.get("ownerId");
            return owners
                    .stream()
                    .filter(owner -> owner.get("id").equals(ownerId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
