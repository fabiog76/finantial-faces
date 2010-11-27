/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rmpestano.finantial.service;

import br.rmpestano.finantial.util.ThemeExtraProperties;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author rmpestano
 */

@ManagedBean(name="themeService")
@SessionScoped
public class ThemeService implements Serializable {
    private String theme = "";
    private ThemeExtraProperties themeProperties;

    public ThemeService() {
//        darkSkyInit();
        uiDarknessInit();
    }



    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void darkSkyInit(){
        theme = "dark-sky";
        themeProperties = new ThemeExtraProperties();
//        themeProperties.setFINANCE_FOOTER_COLOR("#0D31BA");
        themeProperties.setLOADING_ICON("ajax-loader-blue.gif");
//        themeProperties.setBUTTON_BACKGROUND("#AAADB8");
//        themeProperties.setMOUSEOUT_EVENT("this.style.background='#AAADB8'");
//        themeProperties.setMOUSEOVER_EVENT("this.style.background='#333333'");
        themeProperties.setCOLOR("black");
    }
    public void uiDarknessInit(){
        theme = "ui-darkness";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setCOLOR("white");
        themeProperties.setLOADING_ICON("ajax-loader-orange.gif");
    }

     public void aristoInit(){
        theme = "aristo";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setCOLOR("gray");
        themeProperties.setLOADING_ICON("ajax-loader-red.gif");
        themeProperties.setBACKWARD_ARROW("backward_red.png");
        themeProperties.setFORWARD_ARROW("forward_red.png");
    }

    public void vaderInit(){
        theme = "vader";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setCOLOR("white");
        themeProperties.setLOADING_ICON("ajax-loader-red.gif");
    }
    public void dotLuvInit(){
        theme = "dot-luv";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setCOLOR("white");
    }
    public void mintChocInit(){
        theme = "mint-choc";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setCOLOR("white");
        themeProperties.setLOADING_ICON("ajax-loader-green.gif");
    }
    public void overcastInit(){
        theme = "overcast";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setLOADING_ICON("ajax-loader-red.gif");
        themeProperties.setBACKWARD_ARROW("backward_gray.png");
        themeProperties.setFORWARD_ARROW("forward_gray.png");

    }
    public void casablancaInit(){
        theme = "casablanca";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setLOADING_ICON("ajax-loader-black.gif");
        themeProperties.setBACKWARD_ARROW("backward_red.png");
        themeProperties.setFORWARD_ARROW("forward_red.png");
    }
    public void blueSkyInit(){
        theme = "bluesky";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setBACKWARD_ARROW("backward_blue.png");
        themeProperties.setFORWARD_ARROW("forward_blue.png");
    }
    public void cupertinoInit(){
        theme = "cupertino";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setBACKWARD_ARROW("backward_blue.png");
        themeProperties.setFORWARD_ARROW("forward_blue.png");
    }
    public void pepperInit(){
        theme = "pepper-grinder";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setLOADING_ICON("ajax-loader-brown.gif");
    }

    public ThemeExtraProperties getThemeProperties() {
        return themeProperties;
    }








}
