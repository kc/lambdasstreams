package com.example.optionals.authors;

import com.example.streams.pubsdb.data.MemoryPubsDb;
import com.example.streams.pubsdb.domain.model.Author;

import java.util.Optional;

// TODO Lab 6.2, see AuthorDaoTest too
public class AuthorDao {

    private final MemoryPubsDb db = MemoryPubsDb.getInstance();

    Optional<Author> findAuthor(String id) {
        // FIXME 6.2.1
        return null;
    }

    boolean hasWritten(String id, String title) {
        // FIXME 6.2.2
        return false;
    }
}
