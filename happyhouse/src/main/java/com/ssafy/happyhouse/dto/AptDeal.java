package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AptDeal extends AptDto{

    private long no;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private String area;
	private String floor;
	private String cancelDealType;
	private long aptCode;
	
	@Builder
	public AptDeal(String dongCode, int dealYear, int dealMonth){
		super(dongCode);
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
	}

}
