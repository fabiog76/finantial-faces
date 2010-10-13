/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rmpestano.finantial.controller;

import br.rmpestano.finantial.model.User;
import br.rmpestano.finantial.service.UserService;
import br.rmpestano.finantial.util.BeanManagerController;
import br.rmpestano.finantial.util.MessagesController;
import java.io.IOException;
import java.io.Serializable;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rmpestano
 */

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginController implements Serializable{
    UserService userService;
    User user = new User();
    boolean admin = false;
    private String oldPass;
    private String oldPassCheck;
    @PostConstruct
    public void getUserService(){
        userService = (UserService) BeanManagerController.getBeanByName("userService");
    }
    public String doLogin(){


        User user = null;
        try {
            user = userService.findByLogin(this.user.getUsername());

        } catch (Exception e) {
            MessagesController.addError("problemas ao identificar usuário, por favor tente mais tarde",e.getMessage());
            e.printStackTrace();
            return null;
        }
        if(user == null){

            MessagesController.addError("Usuario não encontrado", "Usuário:<b>"+this.user.getUsername()+"</b> não encontrado em nossa base de dados");
            return null;
        }
        else {
            if(user.getPassword().equalsIgnoreCase(this.user.getPassword())){//login feito com sucesso, coloca usuário na sessão
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);

                System.out.println("Login:"+user.getUsername());
                return "/pages/home.faces?faces-redirect=true";
            }
            else{
                MessagesController.addError("senha incorreta ", "senha incorreta, verifique o CAPSLOCK");
                return null;
            }
        }
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getOldPassCheck() {
        return oldPassCheck;
    }

    public void setOldPassCheck(String oldPassCheck) {
        this.oldPassCheck = oldPassCheck;
    }



    public boolean isAdmin() {
        User u = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if( u!= null && u.getId() == 1){
            return true;
        }
        return false;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


     public void doLogout(ActionEvent event) throws IOException{
	     final HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	     request.getSession(false).invalidate();
             FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getContextName());
	}

     public void prepareEditUser(ActionEvent event) throws IOException{
         this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
         if(user == null){
             MessagesController.addError("Voce não está logado, por favor rntr novamente no sistema");
             final HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	     request.getSession(false).invalidate();
             FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getContextName());
         }
     else {
             oldPass = user.getPassword();
             }
     }

     public void checkOldPass(){
             if((oldPassCheck == null || (!oldPass.equals(oldPassCheck))) || (oldPassCheck != null && oldPassCheck.trim().equals(""))){
                MessagesController.addError("A senha antiga informada náo confere");
           }
     }

     public void updateUser(){
        try {
            if((!oldPass.equals(oldPassCheck)) || (oldPassCheck != null && oldPassCheck.trim().equals(""))){
                MessagesController.addError("A senha antiga informada náo confere");
                return;
           }
            userService.atualizar(user);
            MessagesController.addInfo("Perfil atualizado com sucesso");
        } catch (Exception ex) {
            MessagesController.addError("Problemas ao editar usuário:"+ex.getMessage());
        }
     }
}