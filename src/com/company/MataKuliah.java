package com.company;

import java.util.ArrayList;

public class MataKuliah {
    public String code, name;
    public int sks;
    public ArrayList<Nilai> kk = new ArrayList<>();
    public ArrayList<Nilai> kb = new ArrayList<>();

    public Nilai uas;

    public MataKuliah(String code, String name, int sks) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.uas = new Nilai("uas", 0d);
    }

    public void tambahNilai(String type, String name, double score) {
        if (type.equals("UAS")){
            this.uas.namaNilai = name;
            this.uas.nilai = score;
        } else if (type.equals("KB"))
            kb.add(new Nilai(name, score));
        else
            kk.add(new Nilai(name, score));
    }
}
