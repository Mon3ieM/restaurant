
package com.restaurant.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.dto.FoodCategoryWithMenuDTO;
import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.repository.ClientsRepository;
import com.restaurant.model.repository.FoodCategoryRepository;
import com.restaurant.model.repository.FoodMenuRepository;

@Service
@Transactional
public class FoodCategoryService {

	@Autowired
	FoodCategoryRepository repo;

	@Autowired
	FoodMenuRepository repoMenu;

	public List<FoodCategoryWithMenuDTO> listAllCategoryWithMenu() {
		// TODO Auto-generated method stub
		List<FoodCategoryWithMenuDTO> data = new ArrayList<>();

		List<FoodCategory> master = repo.findAll();
		for (FoodCategory fc : master) {
			FoodCategoryWithMenuDTO dto = new FoodCategoryWithMenuDTO();
			dto.setId(fc.getId());
			dto.setName(fc.getName());
			dto.setFoodMenuList(repoMenu.findByFoodCategoryId(fc.getId()));

			data.add(dto);
		}

		return data;
	}

	public List<FoodCategory> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void save(FoodCategory eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}

	public FoodCategory get(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}
}
