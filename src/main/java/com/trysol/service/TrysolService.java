package com.trysol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trysol.model.TrysolWebApp;
import com.trysol.repo.TrysolRepository;

@Service
public class TrysolService {

	@Autowired
	private TrysolRepository trysolRepo;
	
	public void saveResponse(TrysolWebApp webApp) {
		
		trysolRepo.save(webApp);
	}
	
	public void removeResponse(Integer id) {
		trysolRepo.deleteById(id);
	}
	
}
