/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired

    private CategoriaDao clienteDao;

    @Transactional(readOnly=true)
    @Override
    public List<Categoria> getCategorias(boolean activos) {
      var lista= (List<Categoria>) clienteDao.findAll();
      if (activos) { lista.removeIf( e -> !e.isActivo());}
      
      return lista;
    }

    @Transactional
    @Override
    public void save(Categoria cliente) {
        clienteDao.save(cliente);
    }

  @Transactional
    @Override
    public void delete(Categoria cliente) {
        clienteDao.delete(cliente);
    }

     @Transactional(readOnly=true)
    @Override
    public Categoria getCategoria(Categoria cliente) {
   return clienteDao.findById(cliente.getIdCateogoria()).orElse(null);
        
        
        
    }
}
