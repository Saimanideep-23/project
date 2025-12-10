package com.qsp.task_management_project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qsp.task_management_project.model.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class TaskDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public boolean addTaskDao(Task task) {
		if(task!=null) {
			em.persist(task);
			return true;
		}
		
		return false;
	}
	
	
	
	
	public List<Task> getAllTask(){
		
		Query query=em.createQuery("select e from Task e");
		
		return query.getResultList();
	}
	
	
	@Transactional
	public boolean delelteTaskById(int id) {
		
		Task task=em.find(Task.class, id);
		
		if(task!=null) {
			em.remove(task);
			return true;
		}else {
			return false;
		}
		
	
	}
	
	
	
	public Task getTaskByID(int id) {
		return em.find(Task.class, id);
	}
	
	
	
	@Transactional
	public boolean updateTaskDao(Task task) {
		if(task!=null) {
			em.merge(task);
			return true;
		}
		
		return false;
	}
	

}
