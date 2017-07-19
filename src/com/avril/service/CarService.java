package com.avril.service;

import java.util.List;

import com.avril.domain.Cars;
import com.avril.domain.Users;
import com.avril.util.Page;

public interface CarService {

public	void addCar(Cars car);

public Page findUser(Cars car);

public Page findUser(Page Page);
public Page findCar(Page page);

public void delCar(String string);

public Cars preUpdateCar(String carnumber);

public void updateCar(Cars car);

}
