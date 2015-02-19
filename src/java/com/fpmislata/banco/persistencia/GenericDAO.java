
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.common.exceptions.BussinessException;
import java.util.List;

public interface GenericDAO<T, ID> {

    public T get(ID id) throws BussinessException;

    public T insert(T t)throws BussinessException ;

    public T update(T t)throws BussinessException ;

    public void delete(ID id)throws BussinessException ;

    public List<T> findAll()throws BussinessException ;
}
