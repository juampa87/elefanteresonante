package com.elefante.service;

import java.util.List;

import com.elefante.domain.Project;
import com.elefante.search.SearchParams;

public interface ProjectService {

	Project getProject(Integer id);

	void add(Project project);

	void delete(Integer id);

	void edit(Project project);

	List<Project> getAll();

	List<Project> search(SearchParams searchParams);

}
