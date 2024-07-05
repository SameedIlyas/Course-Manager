package dev.scorpius.neo4j_spring_boot.objects;

import dev.scorpius.neo4j_spring_boot.models.Course;

public class CourseEnrollmentDTO {
    private String username;
    private String name;
    private Course course;

    public CourseEnrollmentDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
