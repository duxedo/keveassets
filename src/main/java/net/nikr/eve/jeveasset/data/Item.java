/*
 * Copyright 2009, 2010 Contributors (see credits.txt)
 *
 * This file is part of jEveAssets.
 *
 * jEveAssets is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * jEveAssets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jEveAssets; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package net.nikr.eve.jeveasset.data;

import java.util.List;
import java.util.Vector;


public class Item {

	private int id;
	private String name;
	private String group;
	private String category;
	private long price;
	private float volume;
	private String meta;
	private boolean marketGroup;
	private List<Material> materials;

	public Item(int id, String name, String group, String category, long price, float volume, String meta, boolean marketGroup) {
		this.id = id;
		this.name = name;
		this.group = group;
		this.category = category;
		this.price = price;
		this.volume = volume;
		this.meta = meta;
		this.marketGroup = marketGroup;
		materials = new Vector<Material>();
	}

	public void addMaterial(Material material){
		materials.add(material);
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public String getCategory() {
		return category;
	}

	public String getGroup() {
		return group;
	}

	public int getId() {
		return id;
	}

	public boolean isMarketGroup() {
		return marketGroup;
	}

	public String getMeta() {
		return meta;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public float getVolume() {
		return volume;
	}

	@Override
	public String toString(){
		return name;
	}

	
}