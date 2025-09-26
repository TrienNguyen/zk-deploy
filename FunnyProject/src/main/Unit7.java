package main;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Unit7 extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5, txtNum6, txtNum7, txtNum8, txtNum9, txtDem;

	@Wire
	Button btnMain, btnReset, btnKiemaTra, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

	@Wire
	Label lbDem;

	@Wire
	Radio rdLonHon, rdBeHon, rdBang;

	List<Integer> list;

	int random_tb = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	public void Reload() {
		int min = 0, mintb = 3;
		int max = 10, maxtb = 9;

		int random_int2 = 0, random_int0 = 0, random_int1 = 0, random_int3 = 0, random_int4 = 0, random_int5 = 0,
				random_int6 = 0, random_int7 = 0, random_int8 = 0, random_int9 = 0;

		txtNum0.setValue("");
		txtNum1.setValue("");
		txtNum2.setValue("");
		txtNum3.setValue("");
		txtNum4.setValue("");
		txtNum5.setValue("");
		txtNum6.setValue("");
		txtNum7.setValue("");
		txtNum8.setValue("");
		txtNum9.setValue("");
		do {

			list = new ArrayList<Integer>();
			random_int0 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int4 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int5 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int6 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int7 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int8 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int9 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtNum0.setValue(String.valueOf(random_int0));
			txtNum1.setValue(String.valueOf(random_int1));
			txtNum2.setValue(String.valueOf(random_int2));
			txtNum3.setValue(String.valueOf(random_int3));
			txtNum4.setValue(String.valueOf(random_int4));
			txtNum5.setValue(String.valueOf(random_int5));
			txtNum6.setValue(String.valueOf(random_int6));
			txtNum7.setValue(String.valueOf(random_int7));
			txtNum8.setValue(String.valueOf(random_int8));
			txtNum9.setValue(String.valueOf(random_int9));

			txtDem.setValue("");
			txtDem.setFocus(true);

			list.add(random_int0);
			list.add(random_int1);
			list.add(random_int2);
			list.add(random_int3);
			list.add(random_int4);
			list.add(random_int5);
			list.add(random_int6);
			list.add(random_int7);
			list.add(random_int8);
			list.add(random_int9);

			random_tb = (int) Math.floor(Math.random() * (maxtb - mintb + 1) + mintb);
			if (rdLonHon.isChecked() == true)
				lbDem.setValue("Có bao nhiêu số lớn hơn " + random_tb + "?");
			else if (rdBeHon.isChecked() == true)
				lbDem.setValue("Có bao nhiêu số bé hơn " + random_tb + "?");
			else
				lbDem.setValue("Có bao nhiêu số bằng " + random_tb + "?");

		} while (!(random_int0 != random_int1 && random_int1 != random_int2 && random_int2 != random_int3
				&& random_int3 != random_int0 && random_int0 != random_int2 && random_int1 != random_int3
				&& random_int4 != random_int6 && random_int0 != random_int7 && random_int1 != random_int8
				&& random_int2 != random_int8 && random_int1 != random_int9 && random_int5 != random_int7
				&& random_int4 != random_int5));
	}

	@Listen("onCheck = #rdLonHon, #rdBeHon, #rdBang")
	public void onCheckSoLon() {
		Reload();
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btn0")
	public void onClickbtnTong0() {
		txtDem.setValue("0");
	}

	@Listen("onClick = #btn1")
	public void onClickbtnTong1() {
		txtDem.setValue("1");
	}

	@Listen("onClick = #btn2")
	public void onClickbtnTong2() {
		txtDem.setValue("2");
	}

	@Listen("onClick = #btn3")
	public void onClickbtnTong3() {
		txtDem.setValue("3");
	}

	@Listen("onClick = #btn4")
	public void onClickbtnTong4() {
		txtDem.setValue("4");
	}

	@Listen("onClick = #btn5")
	public void onClickbtnTong5() {
		txtDem.setValue("5");
	}

	@Listen("onClick = #btn6")
	public void onClickbtnTong6() {
		txtDem.setValue("6");
	}

	@Listen("onClick = #btn7")
	public void onClickbtnTong7() {
		txtDem.setValue("7");
	}

	@Listen("onClick = #btn8")
	public void onClickbtnTong8() {
		txtDem.setValue("8");
	}

	@Listen("onClick = #btn9")
	public void onClickbtnTong9() {
		txtDem.setValue("9");
	}

	@Listen("onClick = #btnKiemaTra")
	public void onClickbtnKiemaTra() {
		int demLonHon = 0, demBeHon = 0, demBang = 0;
		if (!txtDem.getValue().equals("")) {
			if (rdLonHon.isChecked() == true) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) > random_tb) {
						demLonHon++;
					}
				}
				if (Integer.valueOf(txtDem.getValue()) == demLonHon) {
					Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
				} else {
					Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
					return;
				}
			} else if (rdBeHon.isChecked() == true) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) < random_tb) {
						demBeHon++;
					}
				}
				if (Integer.valueOf(txtDem.getValue()) == demBeHon) {
					Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
				} else {
					Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
					return;
				}
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == random_tb) {
						demBang++;
					}
				}
				if (Integer.valueOf(txtDem.getValue()) == demBang) {
					Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
				} else {
					Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
					return;
				}
			}
			Reload();
		} else {
			Messagebox.show("Vui lòng nhập kết quả trước khi kiểm tra.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			return;
		}
		
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

}
