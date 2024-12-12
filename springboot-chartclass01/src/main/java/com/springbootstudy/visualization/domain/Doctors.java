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
public class Doctors {
	
	private List<Integer> year;
	private List<Integer> dmale;
	private List<Integer> dfemale;
	private List<Integer> kdmale;
	private List<Integer> kdfemale;
}
