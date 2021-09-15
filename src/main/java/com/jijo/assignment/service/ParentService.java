package com.jijo.assignment.service;

import org.springframework.data.domain.Pageable;

import com.jijo.assignment.dto.ParentResponse;

/**
 * @author Jijo Jose
 *
 */
public interface ParentService {
	ParentResponse findPagableParent(Pageable pageable);
}
