package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.Activity;
import br.com.rlag.alfabetiza.contentservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity activityDetails) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();
            activity.setName(activityDetails.getName());
            activity.setObjectives(activityDetails.getObjectives());
            activity.setPresentationVideoUrl(activityDetails.getPresentationVideoUrl());
            activity.setInstructionVideoUrl(activityDetails.getInstructionVideoUrl());
            activity.setLesson(activityDetails.getLesson());
            activity.setPractices(activityDetails.getPractices());
            return activityRepository.save(activity);
        } else {
            return null;
        }
    }

    public boolean deleteActivity(Long id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}