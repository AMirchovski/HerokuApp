package mk.ukim.finki.wp.kol2022.g3.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
    List<ForumUser> findAllByAgeGreaterThanEqualAndInterestsContains(int age, Interest interest);
    List<ForumUser> findAllByAgeGreaterThanEqual(int age);
    List<ForumUser> findAllByInterestsContains(Interest interest);
}
