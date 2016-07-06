package nl.programit.repository;


import nl.programit.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String name);
    User findByEmail(String email);
}
