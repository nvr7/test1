package com.mastahcode.BelajarSpringBootWeb.service;

import java.util.List;

import com.mastahcode.BelajarSpringBootWeb.model.Mahasiswa;

public interface PageService {
	
	List <Mahasiswa> listMahasiswa();
	Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);
	Mahasiswa getIdMahasiswa(Integer id);
	void hapus (Integer id);

}
