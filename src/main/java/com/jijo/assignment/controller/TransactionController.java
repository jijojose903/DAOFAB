package com.jijo.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jijo.assignment.dto.ParentResponse;
import com.jijo.assignment.exception.ExceptionMessages;
import com.jijo.assignment.exception.ResourceNotFoundException;
import com.jijo.assignment.model.Child;
import com.jijo.assignment.service.ChildService;
import com.jijo.assignment.service.ParentService;

/**
 * Rest controller created for managing the transaction details of parent and
 * child tables
 * 
 * @author Jijo Jose
 *
 */

@RestController
public class TransactionController {
	@Autowired
	private ParentService parentService;

	@Autowired
	private ChildService childService;

	@GetMapping("/parent")
	ParentResponse parentPageable(@PageableDefault(size = 2) Pageable pageable) {
		return parentService.findPagableParent(pageable);
	}

	@GetMapping("/parent/{parentId}")
	List<Child> childDetails(@PathVariable long parentId) {
		List<Child> childDetails = childService.findByParentId(parentId, Sort.by("id").ascending());
		if (CollectionUtils.isEmpty(childDetails))
			throw new ResourceNotFoundException(ExceptionMessages.MSG_RESOURCE_NOT_FOUND);
		return childDetails;
	}
}
