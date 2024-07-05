package dev.scorpius.neo4j_spring_boot.repositories;

import dev.scorpius.neo4j_spring_boot.models.User;
import dev.scorpius.neo4j_spring_boot.queryresults.CourseEnrollmentQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
    "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    Boolean findEnrollmentStatus(String username, String identifier);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
            "CREATE (user)-[:ENROLLED_IN]->(course) RETURN user, course")
    CourseEnrollmentQueryResult createEnrollmentRelation(String username, String identifier);

}
