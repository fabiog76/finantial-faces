/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rmpestano.finantial.util;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;


/**
 *
 * @author rpestano
 */

public class BeanManagerController {


     public static BeanManager getBeanManager(){
          try{
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
          } catch (NamingException e) {
              e.printStackTrace();
            return null;
        }
          
    }
     public static Object getBeanByName(String name) // eg. name=availableCountryDao
    {
        BeanManager bm = getBeanManager();
        Bean bean = bm.getBeans(name).iterator().next();
        CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        Object o = bm.getReference(bean, bean.getClass(), ctx); // could be inlined with return
        return o;
    }




    }


