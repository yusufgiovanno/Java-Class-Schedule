package com.company;
import java.util.ArrayList;

public class Kuliah {
    public MataKuliah matkul;
    public Dosen dosen;
    public ArrayList<Mahasiswa> mahasiswa;

    public Kuliah(MataKuliah matkul, Dosen dosen, ArrayList<Mahasiswa> mahasiswa) {
        this.matkul = matkul;
        this.dosen = dosen;
        this.mahasiswa = mahasiswa;

        for (Mahasiswa student : mahasiswa) {
            student.daftarMatKul(matkul);
        }
    }
}
