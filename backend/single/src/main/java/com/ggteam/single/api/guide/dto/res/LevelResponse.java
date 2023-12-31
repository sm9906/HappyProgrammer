package com.ggteam.single.api.guide.dto.res;

import com.ggteam.single.api.guide.entity.Level;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LevelResponse {

	private Integer id;
	private String name;
	private int hp;
	private int mp;
	private int atk;
	private int def;
	private int needExp;

	public LevelResponse(Level entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.hp = entity.getHp();
		this.mp = entity.getMp();
		this.atk = entity.getAtk();
		this.def = entity.getDef();
		this.needExp = entity.getNeedExp();
	}
}
