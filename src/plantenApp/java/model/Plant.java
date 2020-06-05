package plantenApp.java.model;

import java.util.Date;

/**
 * @author Siebe
 */
public class Plant {
    private int id;
    private String type;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private int minPlantdichtheid;
    private int maxPlantdichtheid;
    private Date lastUpdated;
    private int gebruikerID;
    private String fgsv;
    private int status;
    private AbiotischeFactoren abiotischeFactoren;
    private Beheer beheer;
    private Commensalisme commensalisme;
    private Extra extra;
    private Fenotype fenotype;
    private Foto foto;

    public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid,String fgsv, int status, Date lastUpdated, int gebruikerID) {
        this.id = id;
        this.type = type;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.minPlantdichtheid = minPlantdichtheid;
        this.maxPlantdichtheid = maxPlantdichtheid;
        this.fgsv = fgsv;
        this.status = status;
        this.lastUpdated = lastUpdated;
        this.gebruikerID = gebruikerID;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFamilie() {
        return familie;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getSoort() {
        return soort;
    }

    public String getVariatie() {
        return variatie;
    }

    public int getMinPlantdichtheid() {
        return minPlantdichtheid;
    }

    public int getMaxPlantdichtheid() {
        return maxPlantdichtheid;
    }

    public AbiotischeFactoren getAbiotischeFactoren() {
        return abiotischeFactoren;
    }

    public void setAbiotischeFactoren(AbiotischeFactoren abiotischeFactoren) {
        this.abiotischeFactoren = abiotischeFactoren;
    }

    public Beheer getBeheer() {
        return beheer;
    }

    public void setBeheer(Beheer beheer) {
        this.beheer = beheer;
    }

    public Commensalisme getCommensalisme() {
        return commensalisme;
    }

    public void setCommensalisme(Commensalisme commensalisme) {
        this.commensalisme = commensalisme;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Fenotype getFenotype() {
        return fenotype;
    }

    public void setFenotype(Fenotype fenotype) {
        this.fenotype = fenotype;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public String getFgsv() {
        return fgsv;
    }

    public int getStatus() {
        return status;
    }
    public Date getLastUpdated(){return lastUpdated;}
    public int getGebruikerID(){return gebruikerID;}
}
