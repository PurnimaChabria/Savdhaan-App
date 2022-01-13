package com.example.transaction24;

public class Complains {
    private String complainid;
    private String complainname;
    private String complaindesc;
    private String username;

    public Complains(){

    }

    public String getComplainid() {
        return complainid;
    }

    public String getUsername() {
        return username;
    }

    public String getComplainname() {
        return complainname;
    }

    public String getComplaindesc() {
        return complaindesc;
    }

    public Complains(String complainid, String complainname,String complaindesc,String username) {
        this.complainid = complainid;
        this.complainname = complainname;
        this.complaindesc=complaindesc;
        this.username=username;
    }
}
