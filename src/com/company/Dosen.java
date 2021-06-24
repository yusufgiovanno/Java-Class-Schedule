package com.company;

import java.util.ArrayList;

public class Dosen extends Civitas{
    public Dosen(String nip, String name) {
        super(nip, name);
    }

    public boolean Penilaian(Kuliah class_course, String nim, String type, String score_name, Double score){
        for (Mahasiswa student : class_course.mahasiswa) {
            MataKuliah mk = student.getMatKul(class_course.matkul);
            if (student.ID.equals(nim))
                if (mk != null) {
                    mk.tambahNilai(type, score_name, score);
                    student.IPS();
                    return true;
                }
        }
        return false;
    }

    public void detailNilai(ArrayList<Kuliah> classes){
        System.out.println("\nDetail nilai Dosen "+super.Name);
        for (Kuliah kelas : classes) {
            if (kelas.dosen.ID.equals(super.ID)) {
                System.out.println("Mata Kuliah " + kelas.matkul.name);
                for (Mahasiswa mhs: kelas.mahasiswa){
                    mhs.nilai(kelas.matkul);
                }
            }
        }
    }
}
