package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	/**
	 * 검색
	 * @throws Exception 
	 * */
	ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception;
	
	/**
	 * 등록
	 * */
	ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 수정
	 * */
	ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 삭제
	 * */
	ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
