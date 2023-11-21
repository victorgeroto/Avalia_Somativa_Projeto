package com.ProjetoAvaliaSomativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoAvaliaSomativa.entites.Curso;
import com.ProjetoAvaliaSomativa.repository.CursoRepository;
@Service
public class CursoService {
	private final CursoRepository cursoRepository;
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	public List<Curso> buscaTodosCurso(){
		return cursoRepository.findAll();
	}
	public Curso buscaCursoId(Long id) {
		Optional<Curso> Curso = cursoRepository.findById(id);
		return Curso.orElse(null);
	}
	public Curso salvaCurso(Curso Curso) {
		return cursoRepository.save(Curso);
	}
	public Curso alterarCurso(Long id, Curso alterarCurso) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if(existeCurso.isPresent()) {
			alterarCurso.setId(id);
			return cursoRepository.save(alterarCurso);
		}
		return null;
	}
	public boolean apagarCurso(Long id) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			cursoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
