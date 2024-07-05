package dev.scorpius.neo4j_spring_boot.requests;

public class CourseEnrollmentRequest {
    private String courseIdentifier;

    public CourseEnrollmentRequest() {
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
    }

    public void setCourseIdentifier(String courseIdentifier) {
        this.courseIdentifier = courseIdentifier;
    }
}
