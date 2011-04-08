/*
 * Copyright 2009, 2010, 2011 Contributors (see credits.txt)
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

package net.nikr.eve.jeveassets.tests;

import net.nikr.eve.jeveasset.gui.tabs.routing.EditableListModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Candle
 */
public class TestEditableModel {
	Comparator<ListContents> comp;
	List<ListContents> contents;

	@Before
	public void setup() {
		Comparator<ListContents> comp = new Comparator<ListContents>() {
			@Override
			public int compare(ListContents o1, ListContents o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
		contents = new ArrayList<ListContents>();
		contents.add(new ListContents("abc"));
		contents.add(new ListContents("abcd"));
		contents.add(new ListContents("tgv"));
		contents.add(new ListContents("123"));
		contents.add(new ListContents("gt"));
		contents.add(new ListContents("lt"));
	}

	@Test
	public void testCreate() {
		EditableListModel<ListContents> elm = new EditableListModel<ListContents>(
						contents
						, comp
						);
		assertNotSame("contents should be a different object (unmodifiable list)", contents, elm.getAll());
		assertSame("The comparator should be the same", comp, elm.getSortComparator());
	}

	class ListContents {
		String name;

		public ListContents(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}