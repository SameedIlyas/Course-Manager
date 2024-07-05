package dev.scorpius.neo4j_spring_boot.controllers;

import dev.scorpius.neo4j_spring_boot.models.Course;
import dev.scorpius.neo4j_spring_boot.objects.CourseDTO;
import dev.scorpius.neo4j_spring_boot.objects.CourseEnrollmentDTO;
import dev.scorpius.neo4j_spring_boot.queryresults.CourseEnrollmentQueryResult;
import dev.scorpius.neo4j_spring_boot.requests.CourseEnrollmentRequest;
import dev.scorpius.neo4j_spring_boot.services.CourseEnrollmentService;
import dev.scorpius.neo4j_spring_boot.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/enrollments")
public class CourseEnrollmentController {
    private final CourseEnrollmentService courseEnrollmentService;
    private final LessonService lessonService;

    public CourseEnrollmentController(CourseEnrollmentService courseEnrollmentService, LessonService lessonService) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> enrollments(Principal principal){
        List<Course> courses = courseEnrollmentService.getAllEnrolledCoursesByUsername(principal.getName());

        List<CourseDTO> responseCourses = courses.stream().map(
                (course)-> {
                    CourseDTO responseCourse = new CourseDTO(course.getIdentifier(), course.getTitle(), course.getTeacher());
                    responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));
                    responseCourse.setEnrolled(true);
                    return responseCourse;
                }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(responseCourses, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CourseEnrollmentDTO> enrollIn(@RequestBody CourseEnrollmentRequest request, Principal principal) {
        CourseEnrollmentQueryResult enrollmentQueryResult = courseEnrollmentService.enrollIn(principal.getName(), request.getCourseIdentifier());

        CourseEnrollmentDTO responseEnrollment = new CourseEnrollmentDTO();

        responseEnrollment.setName(enrollmentQueryResult.getUser().getName());
        responseEnrollment.setUsername(enrollmentQueryResult.getUser().getUsername());
        responseEnrollment.setCourse(enrollmentQueryResult.getCourse());

        return new ResponseEntity<>(responseEnrollment, HttpStatus.OK);
    }
}
