package plantenApp.java.model;

import java.util.Date;

/*
 * @author Bart
 */
public class Gebruiker
{
    private int id;
    private String voornaam;
    private String achternaam;
    private String email;
    private String rol;
    private Date aanvraagdatum;
    private int aanvraag_status;
    private int geregistreerd;
    private Date last_login;
    private byte[] wachtwoord_hash;
    private byte[] salt;

    public Gebruiker(int id, String voornaam, String achternaam, String email, String rol, Date aanvraag_datum, int aanvraag_goedgekeurd, int geregistreerd, Date last_login, byte[] wachtwoord_hash, byte[] salt)
    {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.rol = rol;
        this.aanvraagdatum = aanvraag_datum;
        this.aanvraag_status = aanvraag_goedgekeurd;
        this.geregistreerd = geregistreerd;
        this.last_login = last_login;
        this.wachtwoord_hash = wachtwoord_hash;
        this.salt = salt;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public int getID() {
        return id;
    }

    public void setGebruiker_id(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getAanvraagdatum() {
        return aanvraagdatum;
    }

    public void setAanvraagdatum(Date aanvraagdatum) {
        this.aanvraagdatum = aanvraagdatum;
    }

    public int isAanvraag_goedgekeurd() {
        return aanvraag_status;
    }

    public void setAanvraag_status(int aanvraag_status) {
        this.aanvraag_status = aanvraag_status;
    }

    public int isGeregistreerd() {
        return geregistreerd;
    }

    public void setGeregistreerd(int geregistreerd) {
        this.geregistreerd = geregistreerd;
    }

    public Date getLast_login() { return last_login; }

    public void setLast_login(Date last_login) { this.last_login = last_login; }

    public byte[] getWachtwoord_hash() {
        return wachtwoord_hash;
    }

    public void setWachtwoord_hash(byte[] wachtwoord_hash) {
        this.wachtwoord_hash = wachtwoord_hash;
    }
}