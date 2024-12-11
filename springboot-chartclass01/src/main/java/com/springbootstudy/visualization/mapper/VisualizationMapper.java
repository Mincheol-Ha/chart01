package com.springbootstudy.visualization.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springbootstudy.visualization.domain.Cancer;
import com.springbootstudy.visualization.domain.Population;

@Mapper
public interface VisualizationMapper {
	// 연령대별 인구 현황 리스트를 읽어오는 메서드
	public List<Population> populationList();
	
	// 커피숍 영업 현황을 읽어오는 메서드
	public List<Integer> coffeeShopData(String columnName);
	
	// 대장암 발병 현황을 읽어오는 메서드
	public Cancer cancerObject();	
}
