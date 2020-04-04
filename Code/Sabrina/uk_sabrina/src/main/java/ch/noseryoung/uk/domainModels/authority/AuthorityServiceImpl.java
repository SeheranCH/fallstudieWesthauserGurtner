package ch.noseryoung.uk.domainModels.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

// This is an example service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    // The logic for creating a new authority
    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    // The logic for retrieving all authorities
    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    // The logic for retrieving a single authority with a given id
    @Override
    public Authority findById(String id) {
        return authorityRepository.findById(id).get();
    }

    // The logic for updating an existing authority with a given id and data
    @Override
    public Authority updateById(String id, Authority authority) {
        if(authorityRepository.existsById(id)) {
            authority.setId(id);
            authorityRepository.save(authority);

            return authority;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting an authority with a given id
    @Override
    public void deleteById(String id) {
        authorityRepository.deleteById(id);
    }
}
