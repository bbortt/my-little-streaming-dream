package io.github.bbortt.qdrakeboo.core.graphql.api.account.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import io.github.bbortt.qdrakeboo.core.graphql.api.account.service.AccountService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class AccountQueryResolverUnitTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  AccountService accountServiceMock;

  AccountQueryResolver fixture;

  @Before
  public void beforeTestSetup() {

    fixture = new AccountQueryResolver(accountServiceMock);
  }

  @Test
  public void isAnnotated() {
    assertThat(AccountQueryResolver.class).hasAnnotation(Component.class);
  }

  @Test
  public void implementsInterface() {
    assertThat(GraphQLQueryResolver.class).isAssignableFrom(AccountQueryResolver.class);
  }

  @Test
  public void constructorAcceptsArguments() {
    assertThat(new AccountQueryResolver(accountServiceMock))
        .hasFieldOrPropertyWithValue("accountService", accountServiceMock);
  }

  @Test
  public void getAllRolesCallsService() {
    fixture.getAllAccounts();

    verify(accountServiceMock).getAccounts();
  }
}