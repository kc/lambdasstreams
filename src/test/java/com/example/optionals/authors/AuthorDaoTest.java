package com.example.optionals.authors;

import com.example.streams.pubsdb.domain.model.Author;
import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class AuthorDaoTest implements WithAssertions {

    private AuthorDao target;

    @Before
    public void setUp() {
        this.target = new AuthorDao();
    }

    @Test
    public void findAuthor() {
        Optional<Author> author1 = target.findAuthor("1");
        Optional<Author> author2 = target.findAuthor("172-32-1176");

        assertThat(author1).isEmpty();
        assertThat(author2).isNotEmpty();
    }

    @Test
    public void hasWritten() {
        assertThat(target.hasWritten("267-41-2394", "Sushi, Anyone?")).isTrue();
        assertThat(target.hasWritten("172-32-1176", "Kotlin in Action")).isFalse();
        assertThat(target.hasWritten("042-42-4242", "Hitchhiker's Guide")).isFalse();
    }
}
