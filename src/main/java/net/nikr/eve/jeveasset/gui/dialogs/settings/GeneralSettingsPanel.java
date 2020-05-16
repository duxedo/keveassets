/*
 * Copyright 2009-2020 Contributors (see credits.txt)
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

package net.nikr.eve.jeveasset.gui.dialogs.settings;

import com.sun.jna.Platform;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.nikr.eve.jeveasset.Program;
import net.nikr.eve.jeveasset.data.settings.Settings;
import net.nikr.eve.jeveasset.gui.images.Images;
import net.nikr.eve.jeveasset.i18n.DialoguesSettings;


public class GeneralSettingsPanel extends JSettingsPanel {

	private final JCheckBox jEnterFilters;
	private final JCheckBox jHighlightSelectedRow;
	private final JCheckBox jFocusEveOnline;


	public GeneralSettingsPanel(final Program program, final SettingsDialog optionsDialog) {
		super(program, optionsDialog, DialoguesSettings.get().general(),  Images.DIALOG_SETTINGS.getIcon());

		jEnterFilters = new JCheckBox(DialoguesSettings.get().enterFilter());

		jHighlightSelectedRow = new JCheckBox(DialoguesSettings.get().highlightSelectedRow());

		jFocusEveOnline = new JCheckBox(DialoguesSettings.get().focusEveOnline());

		JLabel jFocusEveOnlineLinuxHelp = new JLabel(DialoguesSettings.get().focusEveOnlineLinuxHelp());
		jFocusEveOnlineLinuxHelp.setVisible(Platform.isLinux());
		JTextField jFocusEveOnlineLinuxCmd = new JTextField(DialoguesSettings.get().focusEveOnlineLinuxCmd());
		jFocusEveOnlineLinuxCmd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jFocusEveOnlineLinuxCmd.selectAll();
			}
		});
		jFocusEveOnlineLinuxCmd.setEditable(false);
		jFocusEveOnlineLinuxCmd.setVisible(Platform.isLinux());

		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jEnterFilters)
				.addComponent(jHighlightSelectedRow)
				.addComponent(jFocusEveOnline)
				.addGroup(layout.createSequentialGroup()
					.addGap(30)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jFocusEveOnlineLinuxHelp)
						.addComponent(jFocusEveOnlineLinuxCmd)
					)
				)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(jEnterFilters, Program.getButtonsHeight(), Program.getButtonsHeight(), Program.getButtonsHeight())
				.addComponent(jHighlightSelectedRow, Program.getButtonsHeight(), Program.getButtonsHeight(), Program.getButtonsHeight())
				.addComponent(jFocusEveOnline, Program.getButtonsHeight(), Program.getButtonsHeight(), Program.getButtonsHeight())
				.addComponent(jFocusEveOnlineLinuxHelp, Program.getButtonsHeight(), Program.getButtonsHeight(), Program.getButtonsHeight())
				.addComponent(jFocusEveOnlineLinuxCmd, Program.getButtonsHeight(), Program.getButtonsHeight(), Program.getButtonsHeight())
		);
	}

	@Override
	public boolean save() {
		boolean update = jHighlightSelectedRow.isSelected() != Settings.get().isHighlightSelectedRows();
		Settings.get().setFilterOnEnter(jEnterFilters.isSelected());
		Settings.get().setHighlightSelectedRows(jHighlightSelectedRow.isSelected());
		Settings.get().setFocusEveOnlineOnEsiUiCalls(jFocusEveOnline.isSelected());
		return update;
	}

	@Override
	public void load() {
		jEnterFilters.setSelected(Settings.get().isFilterOnEnter());
		jHighlightSelectedRow.setSelected(Settings.get().isHighlightSelectedRows());
		jFocusEveOnline.setSelected(Settings.get().isFocusEveOnlineOnEsiUiCalls());
	}
}
