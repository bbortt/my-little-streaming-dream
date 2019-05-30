package io.github.bbortt.qdrakeboo.core.graphql.api.account.repository;

import io.github.bbortt.qdrakeboo.core.graphql.api.account.domain.Account;
import io.github.bbortt.qdrakeboo.core.graphql.api.account.domain.Role;
import io.github.bbortt.qdrakeboo.core.graphql.api.account.domain.association.accounthasrole.AccountHasRole;
import io.github.bbortt.qdrakeboo.core.graphql.api.account.domain.association.accounthasrole.AccountHasRoleId;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHasRolesCRUDRepository
    extends CrudRepository<AccountHasRole, AccountHasRoleId> {

  public Set<Role> findAllByAccount(Account account);

  public Set<Account> findAllByRole(Role role);
}