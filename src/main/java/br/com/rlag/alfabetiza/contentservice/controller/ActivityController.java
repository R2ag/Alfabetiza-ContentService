package br.com.rlag.alfabetiza.contentservice.controller;

import br.com.rlag.alfabetiza.contentservice.model.Activity;
import br.com.rlag.alfabetiza.contentservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // Obter todas as atividades
    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return ResponseEntity.ok(activities);
    }

    // Obter uma atividade por ID
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id);
        if (activity != null) {
            return ResponseEntity.ok(activity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova atividade
    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity newActivity = activityService.saveActivity(activity);
        return ResponseEntity.ok(newActivity);
    }

    // Atualizar uma atividade existente
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activityDetails) {
        Activity updatedActivity = activityService.updateActivity(id, activityDetails);
        if (updatedActivity != null) {
            return ResponseEntity.ok(updatedActivity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma atividade
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        boolean isDeleted = activityService.deleteActivity(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}