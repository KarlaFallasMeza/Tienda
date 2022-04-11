/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired

    private ArticuloDao clienteDao;

    @Transactional(readOnly=true)
    @Override
    public List<Articulo> getArticulos(boolean activos) {
      var lista= (List<Articulo>) clienteDao.findAll();
      if (activos) { lista.removeIf( e -> !e.isActivo());}
      
      return lista;
    }

    @Transactional
    @Override
    public void save(Articulo cliente) {
        clienteDao.save(cliente);
    }

  @Transactional
    @Override
    public void delete(Articulo cliente) {
        clienteDao.delete(cliente);
    }

     @Transactional(readOnly=true)
    @Override
    public Articulo getArticulo(Articulo cliente) {
   return clienteDao.findById(cliente.getIdArticulo()).orElse(null);
        
        
        
    }
}