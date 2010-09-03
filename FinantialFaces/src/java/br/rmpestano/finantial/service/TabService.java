/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rmpestano.finantial.service;

import br.rmpestano.finantial.model.FinantialMonth;
import br.rmpestano.finantial.model.FinantialYear;
import br.rmpestano.finantial.service.generic.CrudService;
import br.rmpestano.finantial.util.MessagesController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * this class manage the years and the months in TabPanel
 * @author rmpestano
 */
@Named(value="tabService")
@SessionScoped
public class TabService implements Serializable{
    @Inject CrudService<FinantialYear> yearCrudService;
    @Inject CrudService<FinantialMonth> monthCrudService;
    private Integer monthTabIndex = 0;
    private Integer yearTabIndex = 0;
    private Integer numberOfYearsToView = 6;

  

    public List<FinantialYear> findAll(){
        return yearCrudService.findAll(FinantialYear.class);
    }
    public FinantialYear findById(Long id){
        return yearCrudService.findById(id,FinantialYear.class);
    }

     public void create(FinantialMonth fm){
        try {
            monthCrudService.create(fm);
        } catch (Exception ex) {
            MessagesController.addError("Problemas ao inserir mês:"+fm.getDate(), ex.getMessage());
        }

   }
     
     public String changeNumYearstoView(Integer years){
         this.numberOfYearsToView = years;
         return "/pages/home.faces?faces-redirect=true";
     }
   public void update(FinantialMonth fm){
        try {
            monthCrudService.update(fm);
        }catch (Exception ex) {
            MessagesController.addError("Problemas ao atualizar mês:"+fm.getDate(), ex.getMessage());
            ex.printStackTrace();
            return;
        }
        MessagesController.addInfo("Finança incluida com sucesso!");

   }

    public Integer getMonthTabIndex() {
        return monthTabIndex;
    }

    public void setMonthTabIndex(Integer monthTabIndex) {
        this.monthTabIndex = monthTabIndex;
    }

    public Integer getYearTabIndex() {
        return yearTabIndex;
    }

    public void setYearTabIndex(Integer yearTabIndex) {
        this.yearTabIndex = yearTabIndex;
    }



    public int findYearIndex(String title){
        int index = 0;
        for (FinantialYear finantialYear : yearCrudService.findAll(FinantialYear.class)) {
            if(finantialYear.getTitle().equals(title)){
                return index;
            }
             else{
                index++;
             }
        }
        return -1;//não encontrou
    }

    
public String findfirstYear() {
        StringBuilder firstDate = new StringBuilder();
        List<FinantialYear> firstYear =  yearCrudService.findAll(FinantialYear.class);
        Collections.sort(firstYear);
        FinantialYear fy = firstYear.get(0);
        firstDate.append("01/01/").append(fy.getTitle());
       return firstDate.toString();
    }
public String findlastYear() {
        StringBuilder lastDate = new StringBuilder();
        List<FinantialYear> lastYear =  yearCrudService.findAll(FinantialYear.class);
        Collections.sort(lastYear);

        FinantialYear fy = lastYear.get(numberOfYearsToView-1);
        lastDate.append("31/12/").append(fy.getTitle());
        return lastDate.toString();
    }

public List<FinantialYear> getYearsToView(){
      List<FinantialYear> retorno = new ArrayList<FinantialYear>();
      List<FinantialYear> years =  yearCrudService.findAll(FinantialYear.class);
      Collections.sort(years);
      for (int i = 0; i <  numberOfYearsToView; i++) {
           retorno.add(years.get(i));
    }
      return retorno;

}




    @PostConstruct
    public void init(){
        
        setInitialTabs();
//         if(!PersistenceManager.createEntityManager().createQuery("select f from FinantialYear f").getResultList().isEmpty()){
//            return;
//        }
//        try{
//        for (int i = 2010; i <= 2030; i++) {
//          FinantialYear fy = new FinantialYear();
//          fy.setTitle(""+i);
//            List<FinantialMonth> months = new ArrayList<FinantialMonth>();
//            for (int j = 0; j < 12; j++) {
//                FinantialMonth fm = new FinantialMonth();
//                switch(j){
//                    case 0:{
//                        fm.setTitle("tabyear.label.jan");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 1:{
//                        fm.setTitle("tabyear.label.fev");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 2:{
//                        fm.setTitle("tabyear.label.mar");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 3:{
//                        fm.setTitle("tabyear.label.abr");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 4:{
//                        fm.setTitle("tabyear.label.mai");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 5:{
//                        fm.setTitle("tabyear.label.jun");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 6:{
//                        fm.setTitle("tabyear.label.jul");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 7:{
//                        fm.setTitle("tabyear.label.ago");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 8:{
//                        fm.setTitle("tabyear.label.set");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 9:{
//                        fm.setTitle("tabyear.label.out");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 10:{
//                        fm.setTitle("tabyear.label.nov");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//                    case 11:{
//                        fm.setTitle("tabyear.label.dez");
//                        Calendar c = new GregorianCalendar(i, j, 1);
//                        fm.setDate(c.getTime());
//                        fm.setFinantialYear(fy);
//                        break;
//                    }
//
//                }
//                months.add(fm);
//            }
//          fy.setFinantialMonths(months);
//
//
//          crudService.create(fy);
//        }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }

    }

  
    
    
    private void setInitialTabs() {
        try {
            Date d = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            FinantialMonth fm = FinantialMonth.findByDate(d);

            FinantialYear fy = fm.getFinantialYear();
            yearTabIndex = this.findYearIndex(fy.getTitle());
            monthTabIndex = c.get(Calendar.MONTH);
            System.out.println("Tab Month Inicial:"+monthTabIndex);
            System.out.println("Tab Year Inicial:"+yearTabIndex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Integer getNumberOfYearsToView() {
        return numberOfYearsToView;
    }

    public void setNumberOfYearsToView(Integer numberOfYearsToView) {
        this.numberOfYearsToView = numberOfYearsToView;
    }


}