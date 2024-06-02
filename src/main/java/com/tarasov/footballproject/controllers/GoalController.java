package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetGoalDTO;
import com.tarasov.footballproject.dto.post.PostGoalDTO;
import com.tarasov.footballproject.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/goals")
    public ResponseEntity<Void> saveGoal(@RequestBody PostGoalDTO postGoalDTO) {
        goalService.saveGoal(postGoalDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity<GetGoalDTO> findGoalById(@PathVariable Integer id) {
        GetGoalDTO getGoalDTO = goalService.findGoalById(id);
        return ResponseEntity.ok(getGoalDTO);
    }

    @GetMapping("/goals")
    public ResponseEntity<List<GetGoalDTO>> findAllGoals() {
        List<GetGoalDTO> goalsList = goalService.findAllGoals();
        return ResponseEntity.ok(goalsList);
    }

    @DeleteMapping("/goals/{id}")
    public ResponseEntity<String> deleteGoalById(@PathVariable Integer id) {
        goalService.deleteGoalById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/goals/{id}")
    public ResponseEntity<PostGoalDTO> updateGoal(@PathVariable Integer id, @RequestBody PostGoalDTO postGoalDTO) {
        goalService.updateMatch(id, postGoalDTO);
        return ResponseEntity.ok(postGoalDTO);
    }
}
