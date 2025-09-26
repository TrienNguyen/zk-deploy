package main;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Window;

public class Unit9 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Image imgA, imgT;

	@Wire
	Textbox txtSoTru, txtSoBiTru, txtHieu;

	@Wire
	Button btnMain, btnReset, btnKiemaTra, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	@Listen("onOK = #txtHieu")
	public void onOK() {
		if (!txtHieu.getValue().equals("")) {
			if (Integer.valueOf(txtSoBiTru.getValue()) - Integer.valueOf(txtSoTru.getValue()) == Integer
					.valueOf(txtHieu.getValue())) {
				imgA.setVisible(true);
				imgT.setVisible(false);
			} else {
				txtHieu.setValue("");
				imgA.setVisible(false);
				imgT.setVisible(true);
				return;
			}
		} else {
			Messagebox.show("Vui lòng ch?n k?t qu?!.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}
		Reload();
	}

	public void Reload() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0;
		txtSoBiTru.setValue("");
		txtHieu.setValue("");
		txtSoTru.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoBiTru.setValue(String.valueOf(random_int1));
			txtSoTru.setValue(String.valueOf(random_int2));
		} while (!((random_int1 > random_int2)));
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnKiemaTra")
	public void onClickbtnKiemaTra() {

		if (!txtHieu.getValue().equals("")) {
			if (Integer.valueOf(txtSoBiTru.getValue()) - Integer.valueOf(txtSoTru.getValue()) == Integer
					.valueOf(txtHieu.getValue())) {
				Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			} else {
				Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
				return;
			}
		} else {
			Messagebox.show("Vui lòng chọn kết quả!.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}
		Reload();
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

}
