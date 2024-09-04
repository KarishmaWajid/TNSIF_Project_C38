package com.tnsif.pm_service;


    import org.springframework.data.jpa.repository.JpaRepository;

	public interface CollegeRepository extends JpaRepository<College, Long> {

		
	    // Additional custom queries can be defined here if needed
	}

