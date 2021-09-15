package com.jijo.assignment.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.jijo.assignment.model.Child;

/**
 * @author Jijo Jose
 *
 */
public interface ChildService {
	List<Child> findByParentId(long parentId,Sort sort);

}
