package com.jijo.assignment.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jijo.assignment.model.Child;

/**
 * @author Jijo Jose
 *
 */
public interface ChildRepository extends JpaRepository<Child, Long> {
	List<Child> findByParentId(long parentId, Sort sort);

}
