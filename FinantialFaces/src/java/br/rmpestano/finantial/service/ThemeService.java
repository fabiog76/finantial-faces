/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rmpestano.finantial.service;

import br.rmpestano.finantial.util.ThemeExtraProperties;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author rmpestano
 */
@SessionScoped
@Named(value="themeService")
public class ThemeService implements Serializable {
    private String theme = "";
    private ThemeExtraProperties themeProperties;

    public ThemeService() {
        darkSkyInit();
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

    }
    public void casablancaInit(){
        theme = "casablanca";
        themeProperties = new ThemeExtraProperties();
        themeProperties.setLOADING_ICON("ajax-loader-black.gif");
    }
    public void blueSkyInit(){
        theme = "bluesky";
        themeProperties.setLOADING_ICON("ajax-loader-black.gif");
        themeProperties = new ThemeExtraProperties();
    }
    public void cupertinoInit(){
        theme = "cupertino";
        themeProperties.setLOADING_ICON("ajax-loader-black.gif");
        themeProperties = new ThemeExtraProperties();
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
