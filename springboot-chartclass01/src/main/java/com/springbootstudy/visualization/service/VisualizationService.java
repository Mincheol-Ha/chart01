package com.springbootstudy.visualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstudy.visualization.domain.Cancer;
import com.springbootstudy.visualization.domain.CoffeeShop;
import com.springbootstudy.visualization.domain.PopTimeSeries;
import com.springbootstudy.visualization.domain.Population;
import com.springbootstudy.visualization.mapper.VisualizationMapper;

@Service
public class VisualizationService {

	@Autowired
	private VisualizationMapper visualizationMapper;
	
	public PopTimeSeries popTimeSeries() {
		
		List<Population> populationList = visualizationMapper.populationList();
		PopTimeSeries popTimeSeries = new PopTimeSeries();
		popTimeSeries.setAge0Group(new ArrayList<Integer>());
		popTimeSeries.setAge10Group(new ArrayList<Integer>());
		popTimeSeries.setAge20Group(new ArrayList<Integer>());
		popTimeSeries.setAge30Group(new ArrayList<Integer>());
		popTimeSeries.setAge40Group(new ArrayList<Integer>());
		popTimeSeries.setAge50Group(new ArrayList<Integer>());
		popTimeSeries.setAge60Group(new ArrayList<Integer>());
		popTimeSeries.setAge70Group(new ArrayList<Integer>());
		popTimeSeries.setAge80Group(new ArrayList<Integer>());
		popTimeSeries.setAge90Group(new ArrayList<Integer>());
		popTimeSeries.setTime(new ArrayList<Integer>());		
		
		for(Population p : populationList) {
			// p ? -> 
			// 1960	7941345	5064682	4255785	2926453	2104964	1474230	864140	321593	0	0
			popTimeSeries.getAge0Group().add(p.getAge0());
			popTimeSeries.getAge10Group().add(p.getAge10());
			popTimeSeries.getAge20Group().add(p.getAge20());
			popTimeSeries.getAge30Group().add(p.getAge30());
			popTimeSeries.getAge40Group().add(p.getAge40());
			popTimeSeries.getAge50Group().add(p.getAge50());
			popTimeSeries.getAge60Group().add(p.getAge60());
			popTimeSeries.getAge70Group().add(p.getAge70());
			popTimeSeries.getAge80Group().add(p.getAge80());
			popTimeSeries.getAge90Group().add(p.getAge90());
			popTimeSeries.getTime().add(p.getTime());
		}
		
		return popTimeSeries;
	}
	
	// 커피숍 영업 현황을 읽어오는 메서드
	public CoffeeShop coffeeShopData() { 
		CoffeeShop coffeeShop = new CoffeeShop();
		coffeeShop.setYear(visualizationMapper.coffeeShopData("year"));
		coffeeShop.setOpen(visualizationMapper.coffeeShopData("open"));
		coffeeShop.setClose(visualizationMapper.coffeeShopData("close"));
		
		return coffeeShop;
	}
	
	// 대장암 발병현황을 읽어오는 메서드
	public List<Integer> cancerData() {
		List<Integer> cancerData = new ArrayList<Integer>();
		Cancer cancer = visualizationMapper.cancerObject();
		cancerData.add(cancer.getTeens());
		cancerData.add(cancer.getTwenty());
		cancerData.add(cancer.getThirty());
		cancerData.add(cancer.getForty());
		cancerData.add(cancer.getFifty());
		cancerData.add(cancer.getSixty());
		cancerData.add(cancer.getSeventy());
		cancerData.add(cancer.getEighty());	
		cancerData.add(cancer.getNinety());
		cancerData.add(cancer.getHundred());
		
		return cancerData;
	}
}
