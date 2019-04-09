package io.github.bbortt.qdrakeboo.authorizationserver.graphql.resolver;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import io.github.bbortt.qdrakeboo.authorizationserver.AbstractAuthorizationServerContextAwareTest;
import io.github.bbortt.qdrakeboo.authorizationserver.graphql.GraphQLTestUtil;

@Sql({"classpath:sql/AuthorityQueryIntTest.sql"})
public class AuthorityQueryIntTest extends AbstractAuthorizationServerContextAwareTest {

  @Autowired
  GraphQLTestUtil graphQLTestUtil;

  @Test
  public void getAllRolesReadsRoles() throws Exception {
    ResponseEntity<String> response =
        graphQLTestUtil.post("graphql-tests/getAllAuthorities.graphql")
            .withAuthentication("authority-query-user", "authority-query-password").perform();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody())
        .isEqualTo("{\"data\":{\"allAuthorities\":[{\"name\":\"random-authority\"}]}}");
  }
}
