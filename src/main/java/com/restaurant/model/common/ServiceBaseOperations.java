package com.restaurant.model.common;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceBaseOperations {

	 public List listAll();
	     
	    public void save(Object eo) ;
	    
	    public Object get(BigDecimal id);
	     
	    public void delete(BigDecimal id) ;
}
