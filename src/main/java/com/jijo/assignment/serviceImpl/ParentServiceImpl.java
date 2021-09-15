package com.jijo.assignment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jijo.assignment.dto.ParentResponse;
import com.jijo.assignment.exception.ExceptionMessages;
import com.jijo.assignment.exception.ResourceNotFoundException;
import com.jijo.assignment.model.Parent;
import com.jijo.assignment.repository.ParentRepository;
import com.jijo.assignment.service.ParentService;

/**
 * @author Jijo Jose
 *
 */
@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public ParentResponse findPagableParent(Pageable pageable) {
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending());
		Page<Parent> parentDetails = parentRepository.findAll(page);
		if (parentDetails.isEmpty())
			throw new ResourceNotFoundException(ExceptionMessages.MSG_RESOURCE_NOT_FOUND);
		ParentResponse response = new ParentResponse();
		response.setData(parentDetails.getContent());
		response.setTotalItems(parentDetails.getTotalElements());
		response.setPages(parentDetails.getTotalPages());
		response.seIstLast(parentDetails.isLast());
		response.setIsFirst(parentDetails.isFirst());
		response.setCurrentPage(parentDetails.getNumber());
		return response;
	}
}
