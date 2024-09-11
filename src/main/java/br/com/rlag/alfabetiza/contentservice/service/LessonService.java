package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.Lesson;
import br.com.rlag.alfabetiza.contentservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        if (optionalLesson.isPresent()) {
            Lesson lesson = optionalLesson.get();
            lesson.setName(lessonDetails.getName());
            lesson.setDescription(lessonDetails.getDescription());
            lesson.setUnit(lessonDetails.getUnit());
            lesson.setActivities(lessonDetails.getActivities());
            return lessonRepository.save(lesson);
        } else {
            return null;
        }
    }

    public boolean deleteLesson(Long id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
