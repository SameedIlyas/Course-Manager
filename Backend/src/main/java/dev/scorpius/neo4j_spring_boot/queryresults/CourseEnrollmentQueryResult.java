package dev.scorpius.neo4j_spring_boot.queryresults;

import dev.scorpius.neo4j_spring_boot.models.Course;
import dev.scorpius.neo4j_spring_boot.models.User;

public class CourseEnrollmentQueryResult {
    private User user;
    private Course course;

    public CourseEnrollmentQueryResult() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
