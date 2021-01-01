package com.rab3tech.service;

import com.rab3tech.vo.Dog;

public interface DogService {

	Dog findById(int did);

	int save(Dog dog);

}
