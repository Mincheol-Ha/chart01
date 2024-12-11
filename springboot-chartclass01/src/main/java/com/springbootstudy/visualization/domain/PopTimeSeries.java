package com.springbootstudy.visualization.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PopTimeSeries {
	
	private List<Integer> age0Group;
	private List<Integer> age10Group;
	private List<Integer> age20Group;
	private List<Integer> age30Group;
	private List<Integer> age40Group;
	private List<Integer> age50Group;
	private List<Integer> age60Group;
	private List<Integer> age70Group;
	private List<Integer> age80Group;
	private List<Integer> age90Group;
	private List<Integer> time;
}
