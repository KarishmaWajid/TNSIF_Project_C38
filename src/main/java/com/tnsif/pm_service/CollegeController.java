package com.tnsif.pm_service;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;
	import java.util.Optional;

	@RestController
	@RequestMapping("/colleges")
	public class CollegeController {

	    @Autowired
	    private CollegeService collegeService;

	    @GetMapping
	    public List<College> getAllColleges() {
	        return collegeService.getAllColleges();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
	        Optional<College> college = collegeService.getCollegeById(id);
	        return college.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public College createCollege(@RequestBody College college) {
	        return collegeService.saveCollege(college);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
	        Optional<College> college = collegeService.getCollegeById(id);

	        if (college.isPresent()) {
	            College existingCollege = college.get();
	            existingCollege.setName(collegeDetails.getName());
	            existingCollege.setAddress(collegeDetails.getAddress());
	            existingCollege.setAccreditation(collegeDetails.getAccreditation());
	            existingCollege.setEstablishedDate(collegeDetails.getEstablishedDate());

	            final College updatedCollege = collegeService.saveCollege(existingCollege);
	            return ResponseEntity.ok(updatedCollege);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
	        collegeService.deleteCollege(id);
	        return ResponseEntity.noContent().build();
	    }
	}

