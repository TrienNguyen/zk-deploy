package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Unit14 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Image imgA, imgT;

	@Wire
	Textbox txtSoHang11, txtSoHang12, txtSoHang13, txtTong1, txtSoHang21, txtSoHang22, txtSoHang23, txtTong2,
			txtSoHang31, txtSoHang32, txtSoHang33, txtTong3;

	@Wire
	Button btnMain, btnReset, btnCheck;

	boolean isTrue1 = true, isTrue2 = true, isTrue3 = true;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload1();
		Reload2();
		Reload3();
	}

	@Listen("onClick = #btnCheck")
	public void onClickbtnCheck() {
		Check(txtSoHang11, txtSoHang12, txtSoHang13, txtTong1, 1);
		Check(txtSoHang21, txtSoHang22, txtSoHang23, txtTong2, 2);
		Check(txtSoHang31, txtSoHang32, txtSoHang33, txtTong3, 3);

		if (isTrue1 == true && isTrue2 == true && isTrue3 == true) {
			Reload1();
			Reload2();
			Reload3();
		}
	}

	public void Reload1() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang11.setValue("");
		txtTong1.setValue("");
		txtSoHang12.setValue("");
		txtSoHang13.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 2) + min);

			txtSoHang11.setValue(String.valueOf(random_int1));
			txtSoHang12.setValue(String.valueOf(random_int2));
			txtTong1.setValue(String.valueOf(random_int3));
		} while (!((random_int1 + random_int2) <= random_int3));
	}

	public void Reload2() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang21.setValue("");
		txtTong2.setValue("");
		txtSoHang22.setValue("");
		txtSoHang23.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 2) + min);

			txtSoHang21.setValue(String.valueOf(random_int1));
			txtSoHang23.setValue(String.valueOf(random_int2));
			txtTong2.setValue(String.valueOf(random_int3));
		} while (!((random_int1 + random_int2) <= random_int3));
	}

	public void Reload3() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang31.setValue("");
		txtTong3.setValue("");
		txtSoHang32.setValue("");
		txtTong3.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 2) + min);

			txtSoHang33.setValue(String.valueOf(random_int1));
			txtSoHang32.setValue(String.valueOf(random_int2));
			txtTong3.setValue(String.valueOf(random_int3));
		} while (!((random_int1 + random_int2) <= random_int3));
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload1();
		Reload2();
		Reload3();
	}

	public void Check(Textbox txtSoHang1, Textbox txtSoHang2, Textbox txtSoHang3, Textbox txtTong, int Row) {

		if (!txtSoHang1.getValue().equals("") && !txtSoHang2.getValue().equals("")
				&& !txtSoHang3.getValue().equals("")) {
			if (Integer.valueOf(txtSoHang1.getValue()) + Integer.valueOf(txtSoHang2.getValue())
					+ Integer.valueOf(txtSoHang3.getValue()) == Integer.valueOf(txtTong.getValue())) {
				txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtSoHang2.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtSoHang3.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtTong.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				if (Row == 1)
					isTrue1 = true;
				if (Row == 2)
					isTrue2 = true;
				if (Row == 3)
					isTrue3 = true;
			} else {
				if (Row == 1) {
					txtSoHang3.setValue("");
					txtSoHang3.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue1 = false;
				}
				if (Row == 2) {
					txtSoHang2.setValue("");
					txtSoHang2.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue2 = false;
				}
				if (Row == 3) {
					txtSoHang1.setValue("");
					txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue3 = false;
				}
				return;
			}

		} else {
			Messagebox.show("Vui lòng điền đầy đủ số hạng!", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}

	}

}
