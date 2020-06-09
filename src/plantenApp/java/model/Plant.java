package plantenApp.java.model;

import java.util.Date;

/**
 * @author Siebe
 */
public class Plant {
    private int id;
    private String planttype;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private int minPlantdichtheid;
    private int maxPlantdichtheid;
    private Date laatste_update_datum;
    private int laatste_update_door;
    private String fgsv;
    private int status;
    private AbiotischeFactoren abiotischeFactoren;
    private Beheer beheer;
    private Commensalisme commensalisme;
    private Extra extra;
    private Fenotype fenotype;
    private Foto foto;

    public Plant(int id, String planttype, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid,String fgsv, int status, Date lastUpdated, int gebruikerID) {
        this.id = id;
        this.planttype = planttype;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.minPlantdichtheid = minPlantdichtheid;
        this.maxPlantdichtheid = maxPlantdichtheid;
        this.fgsv = fgsv;
        this.status = status;
        this.laatste_update_datum = lastUpdated;
        this.laatste_update_door = gebruikerID;
    }

    public int getId() {
        return id;
    }

    public String getPlanttype() {
        return planttype;
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

    public Date getLaatste_update_datum(){return laatste_update_datum;}

    public int getLaatste_update_door(){return laatste_update_door;}
}
