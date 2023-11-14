package com.example.demo01010.controller;

import com.example.demo01010.model.TestEntity;
import com.example.demo01010.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestRepository testEntityRepository;

    @PostMapping
    public TestEntity addTestEntity(@RequestBody TestEntity testEntity) {
        // Validation logic if needed
        return testEntityRepository.save(testEntity);
    }

    @GetMapping
    public List<TestEntity> getAllTestEntities() {
        return testEntityRepository.findAll();
    }

    @GetMapping("/{id}")
    public TestEntity getTestEntityById(@PathVariable Long id) {
        return testEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestEntity not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteTestEntityById(@PathVariable Long id) {
        testEntityRepository.deleteById(id);
    }
}
