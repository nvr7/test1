package com.mastahcode.BelajarSpringBootWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mastahcode.BelajarSpringBootWeb.model.Mahasiswa;
import com.mastahcode.BelajarSpringBootWeb.service.PageService;

@Controller
public class PageController {
	
	private PageService pageService;
	
	@Autowired
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	@RequestMapping("/")
	public String MahasiswaList(Model model) {
		model.addAttribute("mahasiswa", pageService.listMahasiswa());
		return "page";
	}
	
	
	@RequestMapping(value ="/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("mahasiswa", new Mahasiswa());
		return "formMahasiswa";
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public String simpanData(Model model, Mahasiswa mahasiswa) {
		model.addAttribute("mahasiswa", pageService.saveOrUpdate(mahasiswa));
		return "redirect:page";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer id, Model model) {
		model.addAttribute("mahasiswa", pageService.getIdMahasiswa(id));
		return "formMahasiswa";
	}
	
	@RequestMapping(value = "/hapus/{id}")
	public String hapus(@PathVariable Integer id) {
		pageService.hapus(id);
		return "redirect:page";
	}

}
