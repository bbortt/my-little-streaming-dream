package io.github.bbortt.qdrakeboo.dev.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DevelopmentApiGateway.class},
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class DevelopmentApiGatewayIntTest {

  @Test
  public void contextLoads() {

  }
}