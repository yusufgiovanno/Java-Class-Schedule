package com.company;

import java.util.ArrayList;

public class Mahasiswa extends Civitas{
    public String study_program;
    private double ips = 0;
    public ArrayList<MataKuliah> courses = new ArrayList<>();

    public Mahasiswa(String nim, String name, String study_program) {
        super(nim, name);
        this.study_program = study_program;
    }

    public double getIps() {
        if (Double.isNaN(ips))
            return 0d;
        return ips;
    }

    public void setIps(double ips) {
        this.ips = ips;
    }

    public void showIPS(){
        System.out.println("IPS "+super.Name+" : "+this.ips);
    }

    public void IPS(){
        double total = 0d;
        int total_sks = 0;
        if (!courses.isEmpty())
            for (MataKuliah mk : courses){

                double total_kk = 0d, total_kb = 0d;
                int count_kk = 0, count_kb = 0;

                if (!mk.kk.isEmpty()){
                    for (Nilai value: mk.kk)
                        total_kk += value.nilai;
                    count_kk = mk.kk.size();
                }

                if (!mk.kb.isEmpty()){
                    for (Nilai value: mk.kb)
                        total_kb += value.nilai;
                    count_kb = mk.kb.size();
                }

                total += ((((total_kk/count_kk)*0.1) + ((total_kb/count_kb)*0.4) + (mk.uas.nilai*0.5)) / 100*4) * mk.sks;
                total_sks += mk.sks;
            }
        ips = total / total_sks;
    }

    public void daftarMatKul(MataKuliah mk){
        courses.add(new MataKuliah(mk.code, mk.name, mk.sks));
        IPS();
    }

    public MataKuliah getMatKul(MataKuliah course){
        for (MataKuliah mk : courses)
            if (mk.code.equals(course.code))
                return mk;
        return null;
    }

    public void nilai(MataKuliah course){
        System.out.println("Nilai " + super.Name);
        MataKuliah mk = getMatKul(course);
        if (mk != null){
            if (!mk.kk.isEmpty())
                for (Nilai kk:mk.kk)
                    System.out.println(kk.namaNilai+" "+kk.nilai);
            if (!mk.kb.isEmpty())
                for (Nilai kb:mk.kb)
                    System.out.println(kb.namaNilai+" "+kb.nilai);
            System.out.println(mk.uas.namaNilai+" "+mk.uas.nilai);
        }
    }

    public void semuaNilai(){
        System.out.println("Semua nilai " + super.Name);

        System.out.println("IPS "+this.getIps());
        for (MataKuliah mk : courses) {
            System.out.println("Mata Kuliah " + mk.name);
            if (!mk.kk.isEmpty())
                for (Nilai kk:mk.kk)
                    System.out.println(kk.namaNilai+" "+kk.nilai);
            if (!mk.kb.isEmpty())
                for (Nilai kb:mk.kb)
                    System.out.println(kb.namaNilai+" "+kb.nilai);
            System.out.println("UAS " + mk.uas.nilai);
        }
    }
}
