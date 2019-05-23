package io.github.bbortt.qdrakeboo.core.graphql.account.service;

import io.github.bbortt.qdrakeboo.core.graphql.account.domain.Role;
import java.util.List;

public interface RoleService {

  List<Role> getRoles();

  Role findByName(String name);
}
