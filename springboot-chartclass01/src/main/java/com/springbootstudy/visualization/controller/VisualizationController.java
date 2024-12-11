package com.springbootstudy.visualization.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootstudy.visualization.domain.CoffeeShop;
import com.springbootstudy.visualization.domain.PopTimeSeries;
import com.springbootstudy.visualization.service.VisualizationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VisualizationController {
	
	private final VisualizationService service;
	
	// Ajax 요청을 처리하는 메서드
	@PostMapping("/ajaxRequest")
	@ResponseBody
	public Object ajaxRequest(@RequestParam("value") String value) {
		
		if(value.equals("coffeeShop")) {
			// {"year": [], "open": [], "close": []}
			return service.coffeeShopData();
			
		} else if(value.equals("cancer")) {
			return service.cancerData();
			
		} else {
			return service.popTimeSeries();
		}
	}
	
	// 연령별 인구현황 차트 HTTP 요청을 처리하는 메서드
	@GetMapping("/popTimeSeries")
	public String popTimeSeries(Model model) {
		
		PopTimeSeries popData = service.popTimeSeries();
		model.addAttribute("popData", popData);
		
		return "/views/popTimeSeries";
	}
	
	// 커피숍 영업 현황 차트 HTTP 요청을 처리하는 메서드
	@GetMapping("/coffeeShop")
	public String coffeeShop(Model model) {
		
		CoffeeShop coffeeShop = service.coffeeShopData();
		model.addAttribute("shopData", coffeeShop);
		
		return "views/coffeeShop";
	}
	
	
	// 대장암 현황 차트 HTTP 요청을 처리하는 메서드
	@GetMapping("/cancer")
	public String cancer(Model model) {
		List<Integer> cancerDatas = service.cancerData();
		model.addAttribute("cancerDatas", cancerDatas);
		
		return "/views/cancer";
	}
}
