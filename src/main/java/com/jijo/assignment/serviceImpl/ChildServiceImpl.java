package com.jijo.assignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jijo.assignment.model.Child;
import com.jijo.assignment.repository.ChildRepository;
import com.jijo.assignment.service.ChildService;

/**
 * @author Jijo Jose
 *
 */
@Service
public class ChildServiceImpl implements ChildService {
	@Autowired
	private ChildRepository childRepository;

	@Override
	public List<Child> findByParentId(long parentId,Sort sort) {
		return childRepository.findByParentId(parentId,sort);
	}

}
