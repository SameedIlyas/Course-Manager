package dev.scorpius.neo4j_spring_boot.services;

import dev.scorpius.neo4j_spring_boot.models.Lesson;
import dev.scorpius.neo4j_spring_boot.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessonsByCourseIdentifier(String identifier) {
       return lessonRepository.findLessonsByCourseIdentifier(identifier);
    }
}
