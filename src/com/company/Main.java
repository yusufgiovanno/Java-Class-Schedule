package com.company;

import java.util.ArrayList;

public class Main {

    private static final ArrayList<Dosen> DOSEN = new ArrayList<>();
    private static final ArrayList<Mahasiswa> MAHASISWA = new ArrayList<>();
    private static final ArrayList<MataKuliah> COURSES = new ArrayList<>();
    private static final ArrayList<Kuliah> KELAS = new ArrayList<>();

    public static void main(String[] args) {
        DOSEN.add(new Dosen("007", "James"));
        DOSEN.add(new Dosen("008", "Bond"));
        MAHASISWA.add(new Mahasiswa("311", "Tom", "Informatika"));
        MAHASISWA.add(new Mahasiswa("321", "Cruise", "Manajemen"));
        COURSES.add(new MataKuliah("EN", "English", 2));
        COURSES.add(new MataKuliah("CN", "Tionghoa", 2));

        ArrayList<Mahasiswa> kelasEN = new ArrayList<>();
        ArrayList<Mahasiswa> kelasCN = new ArrayList<>();
        kelasEN.add(MAHASISWA.get(0));
        kelasCN.add(MAHASISWA.get(1));

        KELAS.add(new Kuliah(COURSES.get(0), DOSEN.get(0), kelasEN));
        KELAS.add(new Kuliah(COURSES.get(1), DOSEN.get(1), kelasCN));

        DOSEN.get(0).Penilaian(KELAS.get(0), MAHASISWA.get(0).ID, "KK" ,"Kuis Kecil",100d);
        DOSEN.get(0).Penilaian(KELAS.get(0), MAHASISWA.get(0).ID, "KB" ,"Kuis Besar",100d);
        DOSEN.get(0).Penilaian(KELAS.get(0), MAHASISWA.get(0).ID, "UAS" , "UAS",100d);

        DOSEN.get(1).Penilaian(KELAS.get(1), MAHASISWA.get(1).ID, "KK" ,"Kuis Kecil",80d);
        DOSEN.get(1).Penilaian(KELAS.get(1), MAHASISWA.get(1).ID, "KB" ,"Kuis Besar",85d);
        DOSEN.get(1).Penilaian(KELAS.get(1), MAHASISWA.get(1).ID, "UAS" , "UAS",95d);

        DOSEN.get(0).detailNilai(KELAS);
        DOSEN.get(1).detailNilai(KELAS);
        System.out.println();
        MAHASISWA.get(0).semuaNilai();
        System.out.println();
        MAHASISWA.get(1).semuaNilai();

    }
}
