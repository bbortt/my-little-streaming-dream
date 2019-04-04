package io.github.bbortt.qdrakeboo.authorizationserver.config.clientdetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import io.github.bbortt.qdrakeboo.authorizationserver.domain.Client;
import io.github.bbortt.qdrakeboo.authorizationserver.domain.repository.ClientCRUDRepository;

public class ClientDetailsServiceImplUnitTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  ClientCRUDRepository clientCRUDRepositoryMock;

  ClientDetailsServiceImpl fixture;

  @Before
  public void beforeTestSetup() {
    fixture = new ClientDetailsServiceImpl(clientCRUDRepositoryMock);
  }

  @Test
  public void isAnnotated() {
    assertThat(ClientDetailsServiceImpl.class).hasAnnotations(Service.class, Primary.class);
  }

  @Test
  public void implementsInterface() {
    assertThat(ClientDetailsService.class).isAssignableFrom(ClientDetailsServiceImpl.class);
  }

  @Test
  public void constructorAcceptsArguments() {
    assertThat(new ClientDetailsServiceImpl(clientCRUDRepositoryMock)).isNotNull()
        .hasFieldOrPropertyWithValue("clientCRUDRepository", clientCRUDRepositoryMock);
  }

  @Test
  public void loadClientByClientIdReturnsClientDetailsImpl() {
    String clientId = "this-is-a-client-id";

    Client client = new Client();
    doReturn(Optional.of(client)).when(clientCRUDRepositoryMock)
        .findOneByClientId(Mockito.eq(clientId));

    assertThat(fixture.loadClientByClientId(clientId)).isInstanceOf(ClientDetailsImpl.class)
        .hasFieldOrPropertyWithValue("client", client);
  }

  @Test
  public void loadClientByClientIdThrowsClientRegistrationException() {
    String clientId = "this-is-a-nonexisting-client-id";

    doReturn(Optional.empty()).when(clientCRUDRepositoryMock)
        .findOneByClientId(Mockito.eq(clientId));

    expectedException.expect(ClientRegistrationException.class);
    expectedException.expectMessage("No client with id '" + clientId + "' registered!");
    fixture.loadClientByClientId(clientId);
  }
}
