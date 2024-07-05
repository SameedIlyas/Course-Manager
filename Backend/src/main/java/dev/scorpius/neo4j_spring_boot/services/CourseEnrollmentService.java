package dev.scorpius.neo4j_spring_boot.services;

import dev.scorpius.neo4j_spring_boot.models.Course;
import dev.scorpius.neo4j_spring_boot.queryresults.CourseEnrollmentQueryResult;
import dev.scorpius.neo4j_spring_boot.repositories.CourseRepository;
import dev.scorpius.neo4j_spring_boot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseEnrollmentService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Boolean getEnrollmentStatus(String username, String identifier) {
        return userRepository.findEnrollmentStatus(username, identifier);
    }

    public CourseEnrollmentQueryResult enrollIn(String username, String identifier) {
        // Check if the user is already enrolled in the course
        Boolean isEnrolled = getEnrollmentStatus(username, identifier);
        if (isEnrolled != null && isEnrolled) {
            throw new IllegalArgumentException("User is already enrolled in this course");
        }
        return userRepository.createEnrollmentRelation(username, identifier);
    }

    public List<Course> getAllEnrolledCoursesByUsername(String username) {
        return courseRepository.findAllEnrolledCoursesByUsername(username);
    }
}
