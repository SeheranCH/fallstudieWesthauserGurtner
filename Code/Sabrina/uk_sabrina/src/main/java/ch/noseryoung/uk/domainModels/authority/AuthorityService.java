package ch.noseryoung.uk.domainModels.authority;

import java.util.List;

// This is an example service with method signatures for CRUD logic
public interface AuthorityService {

    Authority create(Authority authority);

    List<Authority> findAll();

    Authority findById(String id);

    Authority updateById(String id, Authority authority);

    void deleteById(String id);

}
