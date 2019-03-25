package io.github.bbortt.qdrakeboo.authorizationserver.domain.repository.syntaxcheck;

import org.springframework.stereotype.Component;

import io.github.bbortt.qdrakeboo.authorizationserver.domain.repository.AccountRepository;

@Component
public class AccountRepositorySyntaxCheck implements RepositorySyntaxCheck {

  private final AccountRepository accountRepository;

  public AccountRepositorySyntaxCheck(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void checkSyntax() {
    accountRepository.findOneByAccountname("");
  }
}